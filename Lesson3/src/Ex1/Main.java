package Ex1;

public class Main
{
    public static void main(String[] args)
    {
        Phone phone = new Phone();
        phone.onClick();
        phone.onMessage("Yo man!");
        phone.onVolumeUp();
        phone.onVolumeUp();
        phone.onVolumeUp();
        phone.onVolumeUp();
        phone.onMessage("Yo old man!");
    }
}
