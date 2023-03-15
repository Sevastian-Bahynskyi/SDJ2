package Ex2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true)
        {
            Socket socket = serverSocket.accept();
            ClientCommunicator clientCommunicator = new ClientCommunicator(socket);
            Thread client = new Thread(clientCommunicator);
            client.start();
        }
    }
}
