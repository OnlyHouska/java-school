package org.delta.acounts.exceptions;

public class InvalidPinException extends RuntimeException {
    public InvalidPinException() {
        super("Invalid PIN");
    }
}
