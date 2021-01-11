package ro.se.lab.Log;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LogTest {
    private static final String testFileName = "test.txt";

    @Test
    @DisplayName("Log_info_test")
    void info() {
        String testText = "test";
        String logLevel = "INFO";
        Log.fileName = testFileName;
        Log.Info(testText);
        // get log from file
        String resultText = ReadFromFile();
        // make expected log
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String expectedText = "[" + dtf.format(now) +"] ";
        expectedText += logLevel + ":: " + testText + "\n";
        // compare results
        Boolean result = resultText.contains(expectedText);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Log_debug_test")
    void debug() {
        String testText = "test";
        String logLevel = "DEBUG";
        Log.fileName = testFileName;
        Log.Debug(testText);
        // get log from file
        String resultText = ReadFromFile();
        // make expected log
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String expectedText = "[" + dtf.format(now) +"] ";
        expectedText += logLevel + ":: " + testText + "\n";
        // compare results
        Boolean result = resultText.contains(expectedText);
        Assertions.assertEquals(true, result);
    }

    @Test
    @DisplayName("Log_error_test")
    void error() {
        String testText = "test";
        String logLevel = "ERROR";
        Log.fileName = testFileName;
        Log.Error(testText);
        // get log from file
        String resultText = ReadFromFile();
        // make expected log
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MMM/yy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String expectedText = "[" + dtf.format(now) +"] ";
        expectedText += logLevel + ":: " + testText + "\n";
        // compare results
        Boolean result = resultText.contains(expectedText);
        Assertions.assertEquals(true, result);
    }

    private String ReadFromFile()
    {
        char[] buffer = new char[1000];
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(testFileName);
            fileReader.read(buffer);
            // delete everything from file
            FileWriter fileWriter = new FileWriter(testFileName);
            fileWriter.write("");
        } catch (IOException e) {
            System.out.println("FileReader error");
        }
        return String.copyValueOf(buffer);
    }
}