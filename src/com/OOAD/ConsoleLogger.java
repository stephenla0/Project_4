package com.OOAD;

public interface ConsoleLogger {
    default void out(String msg, Logger logger) {
        logger.write(msg);
    }
}
