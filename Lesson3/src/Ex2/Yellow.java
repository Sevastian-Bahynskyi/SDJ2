package Ex2;

public class Yellow implements State
{
    @Override
    public void next(Lights lights)
    {
        lights.setState(new Red());
        lights.turnOff("Yellow", "Green");
        lights.turnOn("Red");
    }

    @Override
    public void printState(Lights lights)
    {
        lights.printLights();
    }
}
