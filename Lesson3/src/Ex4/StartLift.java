package Ex4;

public class StartLift
{
    public static void main(String[] args) throws InterruptedException
    {
        Lift lift = new Lift(15);
        lift.setDestinationFloor(9);
        lift.move();
    }
}
