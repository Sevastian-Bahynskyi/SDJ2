package Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");
        Socket clientSocket = serverSocket.accept();

        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);


            String command;

            command = in.readLine();
            if (!command.equals("connect"))
            {
                out.println("disconnected");
                clientSocket.close();
                return;
            }

            out.println("Server was connected!");

            while(true)
            {
                out.println("Username?");
                String username = in.readLine();
                out.println("Password?");
                String password = in.readLine();

                out.println("Welcome " + username);
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            clientSocket.close();
        }
    }
}
