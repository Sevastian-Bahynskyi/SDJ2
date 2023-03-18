package Ex1.dk.via.log;

import java.io.IOException;

public class Start
{
    public static void main(String[] args) throws IOException
    {
        DefaultLog fileLog = DefaultLog.getInstance();
        fileLog.log("aiegnrg");
    }
}
