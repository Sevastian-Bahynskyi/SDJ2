package Ex3;

public class Main
{
    public static void main(String[] args)
    {
        Thermometer thermometer1 = new Thermometer("t1", 15, 1);
        Thermometer thermometer2 = new Thermometer("t2", 15, 7);
        Thread thread = new Thread(thermometer1);
        Thread thread2 = new Thread(thermometer2);
        thread.start();
        thread2.start();
    }
}
