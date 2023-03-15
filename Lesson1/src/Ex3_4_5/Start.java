package Ex3_4_5;

import java.util.List;

public class Start
{
    public static void main(String[] args) throws InterruptedException
    {
        Runnable numbersRunner1 = new Numbers(25000);
        Runnable numbersRunner2 = new Numbers(25000,50000);
        Runnable numbersRunner3 = new Numbers(50000,75000);
        Runnable numbersRunner4 = new Numbers(75000,100000);
//        Runnable charactersRunner = new Characters(100);
        Thread numbersThread1 = new Thread(numbersRunner1);
        Thread numbersThread2 = new Thread(numbersRunner2);
        Thread numbersThread3 = new Thread(numbersRunner3);
        Thread numbersThread4 = new Thread(numbersRunner4);

        List<Thread> arrayList = List.of(
                numbersThread1,
                numbersThread2,
                numbersThread3,
                numbersThread4
        );



        for (Thread thread:arrayList)
        {
            thread.start();
            thread.join();
        }

//        Thread charactersThread = new Thread(charactersRunner);
//        numbersThread.start();
//        charactersThread.start();
    }
}
