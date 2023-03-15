package Ex4;

public class Main
{
    public static void main(String[] args)
    {
        Burgerbar burgerbar = new Burgerbar(20);
        BurgerBarEmployee employee1 = new BurgerBarEmployee("Bob", burgerbar);
        BurgerBarEmployee employee2 = new BurgerBarEmployee("Paul", burgerbar);
        BurgerBarCustomer customer = new BurgerBarCustomer("Linda",3, burgerbar);
        BurgerBarCustomer customer1 = new BurgerBarCustomer("Linda",3, burgerbar);
        BurgerBarCustomer customer2 = new BurgerBarCustomer("Karen",1, burgerbar);
        BurgerBarCustomer customer3 = new BurgerBarCustomer("John",2, burgerbar);
        BurgerBarCustomer customer4 = new BurgerBarCustomer("Michael",4, burgerbar);

        Thread thread1 = new Thread(employee1);
        Thread thread2 = new Thread(employee2);
        Thread thread3 = new Thread(customer);
        Thread thread4 = new Thread(customer1);
        Thread thread5 = new Thread(customer2);
        Thread thread6 = new Thread(customer3);
        Thread thread7 = new Thread(customer4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}
