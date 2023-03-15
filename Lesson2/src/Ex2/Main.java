package Ex2;

import Ex2.FillList;

public class Main
{
    public static void main(String[] args)
    {
        FillList fillList = new FillList();
        Thread thread1 = new Thread(fillList);
        Thread thread2 = new Thread(fillList);
        thread1.start();
        thread2.start();
    }
}