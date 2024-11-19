package org.delta.accounts.cards;

import jakarta.inject.Inject;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalCardStorage;

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
