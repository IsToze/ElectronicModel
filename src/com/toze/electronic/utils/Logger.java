package com.toze.electronic.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    // Singleton
    private static Logger instance;

    private final SimpleDateFormat dateTimeFormatter;
    private final File file;

    public Logger() {

        if (instance == null)
            instance = this;

        this.dateTimeFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.file = new File("./logs.electronic");

        if (!file.exists()) {
            try {
                file.createNewFile();
                log(LogType.INTERNAL, "Created a new log file, path = " + file.getPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        writeToFile("");

    }

    public static void log(LogType logType, String message) {

        message = "[" + instance.dateTimeFormatter.format(new Date()) + "] " + message + ".";

        System.out.println(logType.c() + message + "\u001B[0m"); // Print & Reset color
        writeToFile(message);

    }

    private static void writeToFile(String message) {

        try {
            final FileWriter writer = new FileWriter(instance.file, true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
