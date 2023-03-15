package Ex4;

public class Burgerbar
{
    private int numbersOfBurgers;
    private int maxNumberOfBurgers;

    public Burgerbar(int maxNumberOfBurgers)
    {
        this.numbersOfBurgers = 0;
        this.maxNumberOfBurgers = maxNumberOfBurgers;
    }

    public synchronized void makeBurger(String employeeName) throws InterruptedException
    {
        while(numbersOfBurgers < maxNumberOfBurgers)
        {
            wait();
        }
        this.numbersOfBurgers++;
        notifyAll();
    }

    public synchronized void eatBurger(String who) throws InterruptedException
    {
        while(numbersOfBurgers > 0)
        {
            wait();
        }
        this.numbersOfBurgers--;
        notifyAll();
    }

    public int getNumbersOfBurgers()
    {
        return numbersOfBurgers;
    }
}
