package Ex1.dk.via.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

enum FileLogType {
    ZERO, ONE, TWO, THREE
}

public class FileLog
{
    private File logFile;
    private CurrentTime currentTime;
    private static final HashMap<FileLogType, FileLog> instances = new HashMap<>();

    private FileLog()
    {
        currentTime = CurrentTime.getInstance();
        logFile = getLogFile();
    }

    public static synchronized FileLog getInstance(FileLogType key)
    {
        if(instances.get(key) == null) {
            instances.put(key, new FileLog());
        }
        return instances.get(key);
    }

    private File getLogFile() {
        String fileName = "Log-" + currentTime.getFormattedIsoDate() + ".txt";
        return new File(fileName);
    }

    public void log(String message) throws IOException
    {
        try (FileWriter fileWriter = new FileWriter(logFile, true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            String logLine = currentTime.getFormattedTime() + " - " + message;
            writer.println(logLine);
        }
    }
}
