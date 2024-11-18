package org.delta.acounts;

import org.delta.acounts.cards.BankCard;
import org.delta.persons.Owner;

import java.util.*;

public class BankAccount {

    private double balance;

    private Owner owner;

    private String accountNumber;

    private Map<String, BankCard> cards = new HashMap<>();

    public BankAccount(double balance, Owner owner, String accountNumber) {
        this.balance = balance;
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankCard getCard(String cardNumber) {
        return cards.get(cardNumber);
    }

    public void addCard(BankCard card) {
        cards.put(card.getNumber(), card);
    }

    public Map<String, BankCard> getCards() {
        return cards;
    }
}
