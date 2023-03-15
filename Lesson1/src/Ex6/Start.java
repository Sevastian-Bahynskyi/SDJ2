package Ex6;

public class Start
{
    public static void main(String[] args) throws InterruptedException
    {
        Counter counter = new Counter();
        CounterIncrement counterIncrement = new CounterIncrement(counter);
        CounterIncrement counterIncrement2 = new CounterIncrement(counter);

        Thread thread = new Thread(counterIncrement);
        Thread thread2 = new Thread(counterIncrement2);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
    }
}
