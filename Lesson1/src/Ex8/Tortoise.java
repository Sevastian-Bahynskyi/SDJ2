package Ex8;

import java.util.Random;

public class Tortoise implements Runnable
{
    private Race race;

    public Tortoise(Race race)
    {
        this.race = race;
    }

    @Override
    public void run()
    {
        try{
            while(true)
            {
                while(true)
                {
                    Thread.sleep(10);
                    race.incrementTortoise();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
