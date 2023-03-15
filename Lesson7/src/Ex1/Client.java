package Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Socket socket = new Socket("10.154.204.133", 5678);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); // for console reading


            String inputVal;
            out.println("connect");
            String response = in.readLine();

            if (response.equals("Disconnected"))
            {
                socket.close();
                return;
            }


            while(true)
            {
                if(!in.readLine().equals("Username?"))
                {
                    break;
                }
                System.out.println("Enter a username: ");
                inputVal = stdIn.readLine();
                out.println(inputVal);

                if(!in.readLine().equals("Password?"))
                {

                    break;
                }
                System.out.println("Enter a password: ");
                inputVal = stdIn.readLine();
                out.println(inputVal);
                System.out.println(in.readLine() + "\n\n");
                Thread.sleep(2000);
            }
            socket.close();
        }
        catch (IOException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
