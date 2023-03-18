package Ex1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class StartClient
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        LoginClient client = new LoginClientImplementation(
                "localhost", 8080, "230.0.0.0", 8888);

        client.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getNewValue());
            }
        });

        client.login("Sevastian", "Fneoiwfge23");
    }
}
