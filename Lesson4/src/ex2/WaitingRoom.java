package ex2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements Runnable
{
    private PropertyChangeSupport support;
    private int currentTicketNumber;


    public WaitingRoom()
    {
        currentTicketNumber = 0;
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void run()
    {
        try
        {
            while(true) {
                System.out.println("\nDiiing!");
                int oldCounter = currentTicketNumber;
                currentTicketNumber++;
                support.firePropertyChange("currentTicketNumber", oldCounter, currentTicketNumber);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    public int getCurrentTicketNumber()
    {
        return currentTicketNumber;
    }
}
