package Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        try
        {
            socket = new Socket("localhost", 8080);
            System.out.println("Client is running...");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("connect");
            String response = in.readLine();
            if(response.equals("Disconnected"))
            {
                System.out.println("Client was not connected to the server");
                socket.close();
                return;
            }

            System.out.println("Client was connected with the server");
            while(true)
            {
                System.out.println("Enter the message: ");
                String message = scanner.nextLine();
                out.println(message);
                Thread.sleep(1000);
            }
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            socket.close();
        }
    }
}
