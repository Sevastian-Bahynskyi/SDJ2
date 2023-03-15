package Ex2;

public class Main
{
    public static void main(String[] args)
    {
        Runnable myClass = new MyClass(100_100_100);
        System.out.println(MyClass.runAndTimeMil(myClass));
        System.out.println(MyClass.runAndTimeNano(myClass));
    }
}