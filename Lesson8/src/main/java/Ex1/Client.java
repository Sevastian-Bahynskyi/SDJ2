package Ex1;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8080);
        ClientImplementation clientImplementation = new ClientImplementation(socket);

        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();
        clientImplementation.sendLogin(new Login(username, password));
    }
}
