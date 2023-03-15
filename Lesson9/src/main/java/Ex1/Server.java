package Ex1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(8080);
        UDPBroadcaster broadcaster = new UDPBroadcaster("230.0.0.0", 8888);

        while(true)
        {
            Socket socket = serverSocket.accept();
            LoginCommunicator loginCommunicator = new LoginCommunicator(socket, broadcaster);
            Thread thread = new Thread(loginCommunicator);
            thread.start();
        }
    }
}
