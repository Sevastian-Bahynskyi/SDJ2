package ex2;

public class Start
{
    public static void main(String[] args)
    {
        Patient patient1 = new Patient(1);
        Patient patient2 = new Patient(2);
        Patient patient3 = new Patient(3);
        Patient patient4 = new Patient(4);
        WaitingRoom waitingRoom = new WaitingRoom();
        Thread thread1 = new Thread(waitingRoom);
        thread1.start();
        waitingRoom.addPropertyChangeListener(patient1);
        waitingRoom.addPropertyChangeListener(patient2);
        waitingRoom.addPropertyChangeListener(patient3);
        waitingRoom.addPropertyChangeListener(patient4);
    }
}
