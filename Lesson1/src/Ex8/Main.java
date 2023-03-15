package Ex8;

public class Main
{
    public static void main(String[] args)
    {
        Race race = new Race();
        Tortoise tortoise = new Tortoise(race);
        Hare hare = new Hare(race);
        Thread tortoiseThread = new Thread(tortoise);
        Thread hareThread = new Thread(hare);
        tortoiseThread.start();
        hareThread.start();
    }
}
