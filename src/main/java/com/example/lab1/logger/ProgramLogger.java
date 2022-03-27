package com.example.lab1.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProgramLogger {
    private static final Logger logger = LogManager.getLogger(ProgramLogger.class);

    public static void log(Level level, Object message) {
        logger.log(level, message);
    }
}