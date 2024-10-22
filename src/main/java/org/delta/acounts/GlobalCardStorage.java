package org.delta.acounts;

import com.google.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
    public class GlobalCardStorage {

    private Map<String, BankAccount> bankCards = new HashMap<>();

    public BankAccount getBankAccount(String cardNumber) {
        return bankCards.get(cardNumber);
    }

    public void addBankCard(String cardNumber, BankAccount bankAccount) {
        bankCards.put(cardNumber, bankAccount);
    }
}
