package Ex2;

public class YellowRed implements State
{
    @Override
    public void next(Lights lights)
    {
        lights.setState(new Green());
        lights.turnOff("Yellow", "Red");
        lights.turnOn("Green");
    }

    @Override
    public void printState(Lights lights)
    {
        lights.printLights();
    }
}
