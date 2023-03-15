package Ex4;

public interface LiftState
{
    public void openDoor(Lift lift) throws InterruptedException;
    public void closeDoor(Lift lift) throws InterruptedException;
    public void moveUp(Lift lift) throws InterruptedException;
    public void moveDown(Lift lift) throws InterruptedException;
    public void stopAndWait(Lift lift);
}
