package Ex1;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class ClientImplementation
{
    private static final String EXIT_JSON = "";

    private final Socket socket;
    private final PrintWriter output;
    private final BufferedReader input;
    private final Gson gson;

    public ClientImplementation(Socket socket) throws IOException
    {
        this.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(socket.getOutputStream(), true);
        this.gson = new Gson();
        System.out.println("Client is running...");
        output.println("connect");
        if(input.readLine().equals("Disconnected"))
        {
            socket.close();
            System.out.println("Failed to connect client to server.");
            return;
        }
        System.out.println("Client was connected to the server.");
    }

    public void sendLogin(Login login) throws IOException
    {
        String request = input.readLine();
        if(!request.equals("login required"))
            return;
        String json = gson.toJson(login);
        output.println(json);
    }
}
