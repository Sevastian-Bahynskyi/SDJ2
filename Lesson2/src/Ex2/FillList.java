package Ex2;

public class FillList implements Runnable
{
    private ListContainer list = new ListContainer();
    @Override
    public void run()
    {
        for (int i = 0; i < 1_000_000; i++)
        {
            list.add(i);
        }
        System.out.println(list.length());
    }
}
