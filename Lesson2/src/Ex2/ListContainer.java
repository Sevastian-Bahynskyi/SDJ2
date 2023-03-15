package Ex2;

import java.util.ArrayList;
import java.util.List;

public class ListContainer
{
    private List<Integer> list;
    private final Object lock = new Object();

    public ListContainer()
    {
        list = new ArrayList<>();
    }

    public void add(int i)
    {
        synchronized (lock)
        {
            list.add(i);
        }
    }

    public int length()
    {
        return this.list.size();
    }
}
