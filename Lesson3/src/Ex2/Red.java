package Ex2;

public class Red implements State
{
    @Override
    public void next(Lights lights)
    {
        lights.setState(new YellowRed());
        lights.turnOn("Yellow", "Red");
        lights.turnOff("Green");
    }

    @Override
    public void printState(Lights lights)
    {
        lights.printLights();
    }
}
