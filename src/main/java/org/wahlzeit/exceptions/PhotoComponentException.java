package org.wahlzeit.exceptions;

public class PhotoComponentException extends Exception {
    public PhotoComponentException() {
    }

    public PhotoComponentException(String message) {
        super(message);
    }

    public PhotoComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhotoComponentException(Throwable cause) {
        super(cause);
    }

    public PhotoComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
