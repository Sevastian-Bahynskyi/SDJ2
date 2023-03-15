package Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> messages = new ArrayList<>();
        try
        {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            System.out.println("Server is running...");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            String command;

            command = in.readLine();
            if(!command.equals("connect"))
            {
                out.println("Disconnected");
                socket.close();
                return;
            }
            out.println("Connected");

            while(true)
            {
                String message = in.readLine();
                System.out.println("The message got from the client: " + message);
                messages.add(message);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
