package com.ellora.Utilities;

import org.apache.log4j.Logger;

public class LogUtil {
    private static Logger logger = Logger.getLogger(LogUtil.class);

    public static void info(String message) {
        logger.info(message);
      
    }

    public static void error(String message) {
        logger.error(message);
        System.out.println(message);
    }
}
