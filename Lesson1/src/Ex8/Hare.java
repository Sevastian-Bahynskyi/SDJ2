package Ex8;

import java.util.Random;

public class Hare implements Runnable
{
    private Race race;
    private Random random;

    public Hare(Race race)
    {
        this.race = race;
        random = new Random();
    }

    @Override
    public void run()
    {
        try{
            while(true)
            {
                if(race.getHareCounter() - race.getTortoiseCounter() < 50)
                {
                    race.incrementHare();
                }
                else {
                    int r = 800 + random.nextInt(500);
                    Thread.sleep(r);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
