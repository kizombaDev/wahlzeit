package org.wahlzeit.exceptions;

public class CoordinateComponentException extends Exception {
    public CoordinateComponentException() {
    }

    public CoordinateComponentException(String message) {
        super(message);
    }

    public CoordinateComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoordinateComponentException(Throwable cause) {
        super(cause);
    }

    public CoordinateComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
