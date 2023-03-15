package Ex4;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BurgerBarCustomer implements Runnable
{
    private int burgersToEat;
    private String name;
    private Burgerbar burgerBar;

    public BurgerBarCustomer(String name, int burgersToEat, Burgerbar burgerBar)
    {
        this.name = name;
        this.burgerBar = burgerBar;
        this.burgersToEat = burgersToEat;
    }

    public void run()
    {
        while(true)
        {
            try
            {
                burgerBar.eatBurger(name);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println(name + " ate a burger at " + LocalDateTime.now().toString().replace("T", " "));
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}
