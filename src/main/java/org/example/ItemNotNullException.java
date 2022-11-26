package org.example;

public class ItemNotNullException extends RuntimeException {
    public ItemNotNullException() {
    }

    public ItemNotNullException(String message) {
        super(message);
    }

    public ItemNotNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotNullException(Throwable cause) {
        super(cause);
    }

    public ItemNotNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
