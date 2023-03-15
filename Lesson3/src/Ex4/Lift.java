package Ex4;

public class Lift
{
    private LiftState liftState;
    private int currentFloor;
    private int destinationFloor;
    private int lastFloor;
    private boolean doorIsOpened;

    public Lift(int lastFloor)
    {
        liftState = new StopAndWaitState();
        this.lastFloor = lastFloor;
        currentFloor = 1;
        doorIsOpened = false;
    }

    protected boolean isDoorOpened()
    {
        return doorIsOpened;
    }

    protected void isDoorOpened(boolean doorIsOpened)
    {
        this.doorIsOpened = doorIsOpened;
    }

    protected int getLastFloor()
    {
        return lastFloor;
    }

    protected void setLiftState(LiftState state)
    {
        this.liftState = state;
    }

    public int getCurrentFloor()
    {
        return currentFloor;
    }

    public void move() throws InterruptedException
    {
        if(destinationFloor > currentFloor)
            moveUp();
        else if (destinationFloor < currentFloor)
            moveDown();
    }

    protected void moveUp() throws InterruptedException
    {
        liftState.moveUp(this);
    }

    protected void moveDown() throws InterruptedException
    {
        liftState.moveDown(this);
    }

    public void openDoor() throws InterruptedException
    {
        liftState.openDoor(this);
    }

    public void closeDoor() throws InterruptedException
    {
        liftState.closeDoor(this);
    }

    public void stopAndWait()
    {
        liftState.stopAndWait(this);
    }

    public void setDestinationFloor(int destinationFloor)
    {
        if(destinationFloor < 1 || destinationFloor > lastFloor)
        {
            System.out.println("Wrong destination floor.");
        }
        else
            this.destinationFloor = destinationFloor;
    }

    protected void incrementCurrentFloor()
    {
        this.currentFloor++;
    }

    protected void decrementCurrentFloor()
    {
        this.currentFloor--;
    }

    public int getDestinationFloor()
    {
        return destinationFloor;
    }
}
