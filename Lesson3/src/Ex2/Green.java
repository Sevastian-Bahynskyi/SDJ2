package Ex2;

public class Green implements State
{
    @Override
    public void next(Lights lights)
    {
        lights.setState(new Yellow());
        lights.turnOff("Green", "Yellow");
        lights.turnOn("Yellow");
    }

    @Override
    public void printState(Lights lights)
    {
        lights.printLights();
    }
}
