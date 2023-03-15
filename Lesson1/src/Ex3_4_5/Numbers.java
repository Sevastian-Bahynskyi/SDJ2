package Ex3_4_5;

public class Numbers implements Runnable
{
    private int iterations;
    private int startNumber;
    public Numbers(int startNumber, int iterations)
    {
        this.iterations = iterations;
        this.startNumber = startNumber;
    }

    public Numbers(int iterations)
    {
        this.iterations = iterations;
        this.startNumber = 0;
    }

    @Override
    public void run() {
        for(int i = startNumber; i < iterations; i++) {
            System.out.println(i);
        }
    }
}
