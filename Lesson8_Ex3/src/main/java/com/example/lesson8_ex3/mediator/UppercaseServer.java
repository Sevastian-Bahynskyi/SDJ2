package com.example.lesson8_ex3.mediator;

import java.io.*;
import java.net.*;

import com.example.lesson8_ex3.model.*;

public class UppercaseServer implements Runnable
{
  private final int PORT = 6789;
  private Model model;
  private boolean running;
  private ServerSocket welcomeSocket;

  public UppercaseServer() {}
  public UppercaseServer(Model model)
  {
    this.model = model;
  }

  @Override public void run()
  {
    try
    {
      welcomeSocket = new ServerSocket(PORT);

      running = true;
      model.addLog("Server is connected.");
      System.out.println(model.getLastLog());
      while (running)
      {
        Socket socket = welcomeSocket.accept();
        UppercaseClientHandler clientHandler = new UppercaseClientHandler(socket, model);
        Thread clientThread = new Thread(clientHandler);
        clientThread.setDaemon(true);
        clientThread.start();
      }
    }
    catch (IOException e)
    {
      //
    }
  }

  public void close()
  {
    running = false;
    try
    {
      welcomeSocket.close();
    }
    catch (Exception e)
    {
      //
    }
  }
}
