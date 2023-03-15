package Ex7;

import java.util.ArrayList;

public class Bar
{
    private ArrayList<Beer> drinks;
    private int size;
    public Bar(int size)
    {
        this.size = size;
        drinks = new ArrayList<>();
    }

    private synchronized void placeBeer() throws InterruptedException
    {
        while(true)
        {
            wait();
        }
        //todo
//        notifyAll();
    }
}
