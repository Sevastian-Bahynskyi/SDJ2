package Ex1;

public class Vibrate implements SpeakerState
{

    @Override
    public void click(Phone phone)
    {
        phone.setState(new Silent());
    }

    @Override
    public void alert(Phone phone)
    {
        System.out.println("BZZZZ");
    }

    @Override
    public void volumeUp(Phone phone)
    {
        phone.setVolume(1);
        phone.setState(new Sound());
    }

    @Override
    public void volumeDown(Phone phone)
    {

    }
}
