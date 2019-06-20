package com.cloud.storage.util;

import org.apache.log4j.Logger;

public class Log {
    static Logger logger = null;

    static {
        logger = Logger.getLogger(Log.class);
    }

    /**
     * @param log
     */
    public static void debug(String log) {
        logger.debug(log);
    }

    /**
     * @param log
     */
    public static void info(String log) {
        logger.info(log);
    }

    /**
     * @param log
     */
    public static void error(String log) {
        logger.error(log);
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        Log.logger = logger;
    }
}
