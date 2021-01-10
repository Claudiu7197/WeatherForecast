package ro.se.lab.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private static Log log = new Log();
    private enum LOG_TYPE
    {
        INFO, ERROR, DEBUG
    }


    private Log() {
        File logFile = new File("logs.txt");
    }

    private static String getLogText(String text, LOG_TYPE type)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String result = "[" + dtf.format(now) +"] ";
        result += type.toString() + ":: " + text + "\n";
        return result;
    }

    public static void Info(String args) {
        try {
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write(getLogText(args, LOG_TYPE.INFO));
            writer.close();
        } catch (IOException e) {
            System.out.println("[ERROR] :: writer");
        }
    }

    public static void Debug(String args) {
        try {
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write(getLogText(args, LOG_TYPE.DEBUG));
            writer.close();
        } catch (IOException e) {
            System.out.println("[ERROR] :: writer");
        }
    }

    public static void Error(String args) {
        try {
            FileWriter writer = new FileWriter("logs.txt", true);
            writer.write(getLogText(args, LOG_TYPE.ERROR));
            writer.close();
        } catch (IOException e) {
            System.out.println("[ERROR] :: writer");
        }
    }
}
