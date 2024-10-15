package org.delta.accounts;

import com.google.inject.Singleton;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class GlobalAccountStorage {
    List<BankAccount> bankAccounts = new LinkedList<>();

    public void save(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }
}
