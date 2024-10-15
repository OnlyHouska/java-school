package org.delta.accounts;

import com.google.inject.Singleton;
import org.delta.accounts.cards.BankCard;

import java.util.HashMap;
import java.util.Map;

@Singleton
public class GlobalCardStorage {
    Map<BankCard, BankAccount> bankCards = new HashMap<>();

    public void save(BankAccount bankAccount, BankCard bankCard) {
        bankCards.put(bankCard, bankAccount);
    }
}
