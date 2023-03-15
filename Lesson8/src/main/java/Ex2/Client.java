package Ex2;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("localhost", 8080);
        ClientImplementation clientImplementation = new ClientImplementation(socket);
        clientImplementation.start();
    }
}
