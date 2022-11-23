package com.toze.electronic.utils;

public enum LogType {

    INTERNAL("\u001B[32m"), // Green color (for information)
    EXTERNAL("\u001B[34m"), // Blue color (for external logs like extensions)
    ERROR("\u001B[31m"), // Red color (for errors)
    DELAY("\u001B[37m"), // White color (for delays checker)
    WARNING("\u001B[33m"); // Yellow color (for warnings);

    private final String color;

    LogType(String name) {
        this.color = name;
    }

    public String c() { // c = color
        return color;
    }

}
