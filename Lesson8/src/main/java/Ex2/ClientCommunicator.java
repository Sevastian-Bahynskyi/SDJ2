package Ex2;

import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class ClientCommunicator implements Runnable
{
    private final Socket socket;

    public ClientCommunicator(Socket socket)
    {
        this.socket = socket;
    }

    public void communicate() throws IOException, ClassNotFoundException
    {
        try{
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            while(true)
            {
                String request = in.readUTF();
                switch (request)
                {
                    case "connect" -> {
                        out.writeUTF("Connected");
                        out.flush();
                        System.out.println("Client was connected to the server.");
                        out.writeUTF("login required");
                        out.flush();
                        Login login = (Login) in.readObject();

                        System.out.println(login);
                        out.writeUTF("approved");
                        out.flush();
                        socket.close();
                        return;
                    }

                    default -> {
                        System.out.println("Client connection was failed.");
                        out.writeUTF("Disconnected");
                        out.flush();
                        socket.close();
                        return;
                    }
                }
            }

        }
        finally
        {
            socket.close();
        }
    }



    @Override
    public void run()
    {
        try {
            communicate();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
