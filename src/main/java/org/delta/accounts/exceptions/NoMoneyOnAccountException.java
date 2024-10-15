package org.delta.accounts.exceptions;

public class NoMoneyOnAccountException extends Exception {

    public NoMoneyOnAccountException(String message) {
        super(message);
    }
}
