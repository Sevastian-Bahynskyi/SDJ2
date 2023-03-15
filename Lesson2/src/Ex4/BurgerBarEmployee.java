package Ex4;

import java.time.LocalDate;

public class BurgerBarEmployee implements Runnable
{
    private String name;
    private Burgerbar burgerBar;

    public BurgerBarEmployee(String name, Burgerbar burgerBar)
    {
        this.name = name;
        this.burgerBar = burgerBar;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                burgerBar.makeBurger(name);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println(name + " made a burger at " + LocalDate.now());
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
