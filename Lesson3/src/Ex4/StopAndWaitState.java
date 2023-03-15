package Ex4;

public class StopAndWaitState implements LiftState
{
    @Override
    public void openDoor(Lift lift) throws InterruptedException
    {
        if(lift.isDoorOpened())
            System.out.println("Lift's door is already opened");
        else{
            System.out.println("Lift is opening the door.");
            Thread.sleep(1000);
            lift.isDoorOpened(true);
        }
    }

    @Override
    public void closeDoor(Lift lift) throws InterruptedException
    {
        if(lift.isDoorOpened())
        {
            System.out.println("Lift is closing the door.");
            Thread.sleep(1000);
            lift.isDoorOpened(false);
        }
        else{
            System.out.println("Lift's door is already closed.");
        }
    }

    @Override
    public void moveUp(Lift lift) throws InterruptedException
    {
        while(lift.getCurrentFloor() < lift.getDestinationFloor())
        {
            if (lift.getCurrentFloor() >= lift.getLastFloor())
            {
                System.out.println("Can't move up, it's the last floor");
                break;
            }
            else
            {
                System.out.println("Current floor is: " + lift.getCurrentFloor());
                System.out.println("Next floor is: " + (lift.getCurrentFloor() + 1) + "\n");
                Thread.sleep(700);
                lift.incrementCurrentFloor();
            }
        }
    }

    @Override
    public void moveDown(Lift lift) throws InterruptedException
    {
        while(lift.getCurrentFloor() > lift.getDestinationFloor())
        {
            if (lift.getCurrentFloor() <= 1)
            {
                System.out.println("Can't move down, it's the first floor");
                break;
            }
            else
            {
                System.out.println("Current floor is: " + lift.getCurrentFloor());
                System.out.println("Next floor is: " + (lift.getCurrentFloor() - 1) + "\n");
                Thread.sleep(700);
                lift.decrementCurrentFloor();
            }
        }
    }

    @Override
    public void stopAndWait(Lift lift)
    {
        System.out.println("List has already stopped and it's ready to move.");
    }
}
