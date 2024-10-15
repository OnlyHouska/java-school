package org.delta.accounts.cards;

public class BankCard {
    private final String number;
    private final String pin;

    public BankCard(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }
}
