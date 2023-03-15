package Ex4;

public class MoveUpState implements LiftState
{

    @Override
    public void openDoor(Lift lift)
    {
        System.out.println("Can't open the door while lift is moving.");
    }

    @Override
    public void closeDoor(Lift lift)
    {
        System.out.println("Door is already closed");
    }

    @Override
    public void moveUp(Lift lift)
    {
        System.out.println("Lift is already moving up.");
    }

    @Override
    public void moveDown(Lift lift)
    {
        System.out.println("Lift can't change it's direction while it's moving.");
    }

    @Override
    public void stopAndWait(Lift lift)
    {
        if (lift.getCurrentFloor() == lift.getDestinationFloor())
        {
            System.out.println("Lift got to destination floor.");
            lift.setLiftState(new StopAndWaitState());
        }
        else{
            System.out.println("Lift didn't get to destination floor.");
        }
    }
}
