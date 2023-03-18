package Ex1;

import com.google.gson.Gson;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginClientImplementation implements LoginClient
{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Gson gson;
    private PropertyChangeSupport support;
    private MessageListener listener;

    public LoginClientImplementation(String host, int port, String groupAddress, int groupPort) throws IOException
    {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        gson = new Gson();
        support = new PropertyChangeSupport(this);
        listener = new MessageListener(this, groupAddress, groupPort);
        Thread thread = new Thread(listener);
        thread.start();
    }
    @Override
    public void login(String username, String password)
    {
        Login login = new Login(username, password);
        String json = gson.toJson(login);
        out.println(json);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }

    public void receiveBroadcast(String message) throws IOException
    {
        Login login = gson.fromJson(message, Login.class);
        System.out.println(message);
        support.firePropertyChange("login", null, login);
    }
}
