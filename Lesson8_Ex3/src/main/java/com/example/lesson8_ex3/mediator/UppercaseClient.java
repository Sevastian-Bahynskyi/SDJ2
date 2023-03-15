package com.example.lesson8_ex3.mediator;

import com.example.lesson8_ex3.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UppercaseClient implements ServerModel, Runnable
{
    private final int PORT = 6789;
    private final String HOST = "localhost";
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String userName;


    public UppercaseClient(String host, int port) throws IOException
    {
        this.host = host;
        this.port = port;
    }

    public UppercaseClient(String userName) throws IOException
    {
        this.host = HOST;
        this.port = PORT;
        this.userName = userName;
    }



    @Override
    public void connect() throws IOException
    {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        out.println(userName);
    }

    @Override
    public void disconnect() throws IOException
    {
        in.close();
        out.close();
        socket.close();
    }

    @Override
    public String convert(String source) throws IOException
    {
        out.println(source);
        return in.readLine();
    }

    @Override
    public void run()
    {
        try
        {
            connect();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
