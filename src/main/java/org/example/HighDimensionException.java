package org.example;

public class HighDimensionException extends RuntimeException {
    public HighDimensionException() {
    }

    public HighDimensionException(String message) {
        super(message);
    }

    public HighDimensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public HighDimensionException(Throwable cause) {
        super(cause);
    }

    public HighDimensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
