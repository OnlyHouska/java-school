package org.delta.accounts;

import com.google.inject.Singleton;
import org.delta.persons.Owner;

public class SavingBankAccount extends BankAccount {

    public SavingBankAccount(double balance, Owner owner, String accountNumber) {
        super(accountNumber, balance, owner);
    }
}
