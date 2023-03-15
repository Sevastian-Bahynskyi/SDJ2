package com.example.lesson8_ex4.mediator;

import com.example.lesson8_ex4.model.UserModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer implements Runnable
{
    private final int PORT = 8080;
    private ServerSocket serverSocket;
    private boolean isRunning;
    private UserModel model;

    public LoginServer(UserModel model)
    {
        this.model = model;
    }


    @Override
    public void run()
    {
        try
        {
            serverSocket = new ServerSocket(PORT);
            isRunning = true;
            while (isRunning)
            {
                Socket clientSocket = serverSocket.accept();
                LoginClientHandler clientHandler = new LoginClientHandler(clientSocket, model);
                Thread currentClient = new Thread(clientHandler);
                currentClient.setDaemon(true);
                currentClient.start();
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
