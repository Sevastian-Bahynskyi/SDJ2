package Ex1;

public class Phone
{
    private SpeakerState state;
    private int volume;

    public Phone()
    {
        state = new Sound();
        volume = 0;
    }

    public void onClick()
    {
        state.click(this);
        if(state instanceof Sound)
        {
            System.out.println("Sound mode is on");
        }
        else if(state instanceof Vibrate)
        {
            System.out.println("Vibrate mode is on");
        }
        else if(state instanceof Silent)
        {
            System.out.println("Silent mode is on");
        }
    }

    public void onMessage(String message)
    {
        System.out.println(message);
        state.alert(this);
        logVolume();
    }

    public void onVolumeUp()
    {
        state.volumeUp(this);
        System.out.println("Volume up was pressed");
        logVolume();
    }

    public void onVolumeDown()
    {
        state.volumeDown(this);
        System.out.println("Volume up was pressed");
        logVolume();
    }

    protected void setState(SpeakerState state)
    {
        this.state = state;
    }
    protected int getVolume()
    {
        return volume;
    }

    protected void setVolume(int volume)
    {
        this.volume = volume;
    }

    public void logVolume()
    {
        System.out.println("Volume level  - " + volume);
    }
}
