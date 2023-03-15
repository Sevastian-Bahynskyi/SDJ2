package com.example.lesson8_ex3.mediator;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import com.example.lesson8_ex3.mediator.*;
import com.example.lesson8_ex3.model.*;
import com.example.lesson8_ex3.view.*;

public class UppercaseClientHandler implements Runnable
{
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  public ArrayList<UppercaseClientHandler> clientHandlers = new ArrayList<>();
  public String userName;
  private Model model;
  private boolean running;

  public UppercaseClientHandler(Socket socket, Model model) throws IOException
  {
    this.model = model;
    this.socket = socket;
    this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.out = new PrintWriter(socket.getOutputStream(), true);
    this.userName = in.readLine();
    model.addLog("----> " + userName + " joined the server");
    System.out.println(model.getLastLog());
    this.clientHandlers.add(this);
  }

  @Override
  public void run()
  {
    running = true;
    while (running)
    {
      try
      {
        String request = in.readLine();
//        String reply = model.convert(request);
        String result = request.toUpperCase();
        out.println(result);
        model.addLog("----> " + userName + " entered " + request + " and got " + result);
        System.out.println(model.getLastLog());
        //todo -> add log, in model manager user converter class for that and display current log to server
        // try to find the way to give names for clients
        if (request.contentEquals("quit"))
        {
          close();
        }
      }
      catch (Exception e)
      {
        close();
      }
    }
    close();
  }
  
  public void close()
  {
    running = false;
    try
    {
      in.close();
      out.close();
      socket.close();
    }
    catch (IOException e)
    {
      //
    }
  }
}
