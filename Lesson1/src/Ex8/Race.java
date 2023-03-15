package Ex8;

import javax.swing.plaf.SliderUI;
import java.util.Random;

public class Race
{
    private int tortoiseCounter;
    private int hareCounter;

    public Race()
    {
        tortoiseCounter = 0;
        hareCounter = 0;
    }

    public int getHareCounter()
    {
        return hareCounter;
    }

    public int getTortoiseCounter()
    {
        return tortoiseCounter;
    }


    public void incrementTortoise() throws InterruptedException
    {
        tortoiseCounter++;
        System.out.println("Tortoise: " + tortoiseCounter);
        if(tortoiseCounter == 1000)
        {
            System.out.println("Tortoise win");
            System.exit(0);
        }
    }

    public void incrementHare() throws InterruptedException
    {
        hareCounter++;
        System.out.println("Hare: " + hareCounter);
        if(hareCounter == 1000)
        {
            System.out.println("Hare win");
            System.exit(0);
        }
    }

}
