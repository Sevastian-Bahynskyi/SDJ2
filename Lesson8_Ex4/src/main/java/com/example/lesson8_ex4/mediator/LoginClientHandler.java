package com.example.lesson8_ex4.mediator;

import com.example.lesson8_ex4.model.User;
import com.example.lesson8_ex4.model.UserModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class LoginClientHandler implements Runnable
{
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean isRunning;
    private UserModel model;
    private ArrayList<LoginClientHandler> clientHandlers = new ArrayList<>();

    public LoginClientHandler(Socket socket, UserModel model) throws IOException
    {
        this.socket = socket;
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        this.model = model;
        clientHandlers.add(this);
        if(in.readUTF().equals("send_me_model"))
        {
            out.writeObject(model);
            out.flush();
        }
    }

    public void run()
    {
        try
        {
            User user = (User) in.readObject();
            model.getUserList().add(user);
            out.writeUTF("approved");
            out.flush();
                // todo something wrong with threads,
                //  it does add user and fire property in model, but GUI updates first
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            } catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
