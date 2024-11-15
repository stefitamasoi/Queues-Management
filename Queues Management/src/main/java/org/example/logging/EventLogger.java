package org.example.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EventLogger {
    private static final String LOG_FILE = "LogEvents.log";

    public static synchronized void log(String event) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(event);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
