package Ex3_4_5;

public class Characters implements Runnable
{
    private int iterations;
    public Characters(int iterations)
    {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        int i = 0;
            for (char c = 'A'; i < iterations ; c++, i++) {
                if(c == 'Z' + 1)
                    c = 'A';
                System.out.println(c);
            }
    }
}
