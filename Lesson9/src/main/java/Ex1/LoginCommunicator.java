package Ex1;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LoginCommunicator implements Runnable
{
    private final Socket socket;
    private final UDPBroadcaster broadcaster;
    private final Gson gson;

    public LoginCommunicator(Socket socket, UDPBroadcaster broadcaster) throws IOException
    {
        this.broadcaster = broadcaster;
        this.socket = socket;

        this.gson = new Gson();
    }

    private void communicate() throws IOException
    {
        try
        {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while(true)
            {

                String json = in.readLine();
                Login login = gson.fromJson(json, Login.class);

                System.out.println(login);
                out.println(json);
                broadcaster.broadcast(json);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            synchronized (broadcaster) {
            }
            socket.close();
        }
    }

    @Override
    public void run()
    {
        try
        {
            communicate();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
