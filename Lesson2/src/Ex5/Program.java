package Ex5;

public class Program implements Runnable
{
    private String program;
    private String action;
    private int count;
    private static final int RUNTIME = 100_100;

    public Program(String program, String action, int count)
    {
        this.program = program;
        this.action = action;
        this.count = count;
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(program + " wants to " + action);
            try {
                Thread.sleep((RUNTIME / count));
            } catch (InterruptedException e) {
                // Handle the exception
            }
        }
    }
}
