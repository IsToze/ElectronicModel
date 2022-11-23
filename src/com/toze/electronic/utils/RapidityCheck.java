package com.toze.electronic.utils;

import java.util.HashMap;
import java.util.Map;

public class RapidityCheck {

    public static Map<String, Long> times = new HashMap<>();

    public static void register(String name) {
        times.put(name, System.currentTimeMillis());
    }

    public static long check(String name) {
        final long delay = System.currentTimeMillis() - times.get(name);
        times.remove(name);
        return delay;
    }

    public static long checkLog(String utility, String name) {
        final long delay = check(name);
        Logger.log(LogType.DELAY, utility + " took " + delay + "ms to execute.");
        return delay;
    }

}
