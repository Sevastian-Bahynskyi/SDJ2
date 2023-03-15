package ex2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{
    private int ticket;
    public Patient(int ticket)
    {
        this.ticket = ticket;
        enterWaitingRoom();
    }

    public void onTicketAlert(WaitingRoom waitingRoom)
    {
        getAlert();
        if(waitingRoom.getCurrentTicketNumber() == ticket)
        {
            enterDoctorRoom();
            waitingRoom.removePropertyChangeListener(this);
        } else {
            goBackToPhone();
        }
    }

    private void goBackToPhone()
    {
        System.out.println("Patient with ticket " + ticket + " goes back to looking at phone.");
    }

    private void getAlert()
    {
        System.out.println("Patient with ticket " + ticket + " looks up.");
    }

    private void enterWaitingRoom()
    {
        System.out.println("Patient with ticket " + ticket + " enters waiting room.");
    }

    private void enterDoctorRoom()
    {
        System.out.println("Patient with ticket " + ticket + " enters doctor's room.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        WaitingRoom wr = (WaitingRoom) evt.getSource();
        onTicketAlert(wr);
    }
}
