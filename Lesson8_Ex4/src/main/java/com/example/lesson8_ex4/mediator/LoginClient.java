package com.example.lesson8_ex4.mediator;

import com.example.lesson8_ex4.model.Email;
import com.example.lesson8_ex4.model.EmailFactory;
import com.example.lesson8_ex4.model.User;
import com.example.lesson8_ex4.model.UserModel;
import com.example.lesson8_ex4.model.validation.PasswordValidator;
import com.example.lesson8_ex4.model.validation.UsernameValidator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LoginClient implements ServerModel, Runnable
{
    private final String HOST = "localhost";
    private final int PORT = 8080;
    private String host;
    private int port;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private UserModel model;

    public LoginClient()
    {
        this.host = HOST;
        this.port = PORT;
    }

    public LoginClient(String host, int port)
    {
        this.host = host;
        this.port = port;
    }
    @Override
    public void connect() throws IOException, ClassNotFoundException
    {
        socket = new Socket(host, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        out.writeUTF("send_me_model");
        out.flush();
        this.model = (UserModel) in.readObject();
        int i = 0;
    }

    @Override
    public void disconnect() throws IOException
    {
        socket.close();
        in.close();
        out.close();
    }

    @Override
    public void addUser(String username, String password, String emailString) throws IOException
    {
        UsernameValidator.validateUsername(username);
        PasswordValidator.validatePassword(password);
        Email email = EmailFactory.createEmail(emailString);
        if (model.getUser(username) != null) {
            throw new IllegalStateException("User already exists.");
        }
        User user = new User(username, password, email);
        out.writeObject(user);
        out.flush();
        String response = "";
        while(!response.equals("approved"))
        {
            response = in.readUTF();
        }
    }

    @Override
    public void run()
    {
        try{
            connect();
        } catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public UserModel getModel()
    {
        return model;
    }
}
