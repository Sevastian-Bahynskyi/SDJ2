package Ex7;

public class Start
{
    public static void main(String[] args)
    {
        Runnable runnable = new StupidTimer(30);
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
