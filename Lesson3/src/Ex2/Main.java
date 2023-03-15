package Ex2;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Lights lights = new Lights();
        for (int i = 0; i < 5; i++)
        {
            lights.next();
            lights.printLights();
        }
    }
}
