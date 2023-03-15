package Ex1;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientCommunicator
{
    private final Socket socket;
    private Gson gson;

    public ClientCommunicator(Socket socket)
    {
        this.socket = socket;
        this.gson = new Gson();
    }

    public void communicate() throws IOException
    {
        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            if(!in.readLine().equals("connect"))
            {
                System.out.println("Client connection was failed.");
                out.println("Disconnected");
                socket.close();
                return;
            }


            out.println("Connected");
            System.out.println("Client was connected to the server.");

            out.println("login required");
            String json = in.readLine();
            Login login = gson.fromJson(json, Login.class);

            System.out.println(login);
            out.println("approved");
        }
        finally
        {
            socket.close();
        }
    }
}
