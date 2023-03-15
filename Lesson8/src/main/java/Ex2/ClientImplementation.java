package Ex2;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientImplementation
{
    private static final String EXIT_JSON = "";

    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;

    public ClientImplementation(Socket socket) throws IOException
    {
        this.socket = socket;
        this.input = new ObjectInputStream(socket.getInputStream());
        this.output = new ObjectOutputStream(socket.getOutputStream());
    }

    public void start() throws IOException
    {
        System.out.println("Client is running...");
        output.writeUTF("connect");
        output.flush();
        while(true)
        {
            String request = input.readUTF();
            switch (request)
            {
                case "Disconnected" ->
                {
                    socket.close();
                    System.out.println("Failed to connect client to server.");
                    socket.close();
                    return;
                }

                case "Connected" -> System.out.println("Client was connected to the server.");

                case "login required" -> sendLogin();

                case "approved" -> {
                    socket.close();
                    return;
                }

                default ->  throw new RuntimeException("Client doesn't know this protocol");
            }
        }
    }

    public void close() throws IOException
    {
        socket.close();
    }

    public void sendLogin() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();
        Login login = new Login(username, password);
        output.writeObject(login);
        output.flush();
    }
}
