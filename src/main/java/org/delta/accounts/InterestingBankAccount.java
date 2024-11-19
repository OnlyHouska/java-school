package org.delta.accounts;

import org.delta.persons.Owner;

public class InterestingBankAccount extends BankAccount {
    public InterestingBankAccount(String accountNumber, double balance, Owner owner) {
        super(accountNumber, balance, owner);
    }

    public double getInterest() {
        return 0;
    }
}
