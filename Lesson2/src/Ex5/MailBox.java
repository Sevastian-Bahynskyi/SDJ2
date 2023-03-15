package Ex5;

public class MailBox implements Runnable
{
    private int count;
    private static final int RUNTIME = 100_100;

    public MailBox(int count)
    {
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("New mail in your mail box...");
            try {
                Thread.sleep((int) (RUNTIME / count));
            } catch (InterruptedException e) {
                // Handle the exception
            }
        }
    }
}
