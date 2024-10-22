package org.delta.acounts.cards;

import org.delta.acounts.BankAccount;

public class BankCard {

    private String number;

    private String pin;

    private BankAccount bankAccount;

    public BankCard(String number, String pin, BankAccount bankAccount) {
        this.number = number;
        this.pin = pin;
        this.bankAccount = bankAccount;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
