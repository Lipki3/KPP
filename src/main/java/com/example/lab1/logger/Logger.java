package com.example.lab1.logger;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class Logger {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

    public static void log(Level level, Object message) {
        logger.log(level, message);
    }

}