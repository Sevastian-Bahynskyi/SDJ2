package Ex6;

public class CounterIncrement implements Runnable
{
    private Counter counter;

    public CounterIncrement(Counter counter)
    {
        this.counter = counter;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 1_000_000; i++)
        {
            counter.incrementCount();
        }
        System.out.println(counter.getCount());
    }
}
