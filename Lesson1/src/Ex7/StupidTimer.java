package Ex7;

public class StupidTimer implements Runnable
{
    private int timeInterval;
    public StupidTimer(int timeInterval)
    {
        this.timeInterval = timeInterval;
    }
    @Override
    public void run()
    {
        for (int i = 1; i <= timeInterval; i++)
        {
            try
            {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
