package Ex2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

public class MyClass implements Runnable
{
    private int size;

    public MyClass(int size)
    {
        this.size = size;
    }
    private static long[] randomArray(int size) {
        Random random = new Random();
        long[] array = new long[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextLong();
        }
        return array;
    }

    @Override
    public void run()
    {
        Arrays.sort(randomArray(size));
    }

    public static BigInteger runAndTimeMil(Runnable runnable)
    {
        BigInteger start = BigInteger.valueOf(System.currentTimeMillis());
        runnable.run();
        return BigInteger.valueOf(System.currentTimeMillis()).subtract(start);
    }

    public static BigInteger runAndTimeNano(Runnable runnable)
    {
        BigInteger start = BigInteger.valueOf(System.nanoTime());
        runnable.run();
        return BigInteger.valueOf(System.nanoTime()).subtract(start);
    }
}
