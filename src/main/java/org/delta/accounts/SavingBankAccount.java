package org.delta.accounts;

import org.delta.persons.Owner;

public class SavingBankAccount extends BankAccount implements Interesting {

    public SavingBankAccount(double balance, Owner owner, String accountNumber) {
        super(accountNumber, balance, owner);
    }

    @Override
    public double getInterest() {
        if (this.getBalance() < 500000) {
            return 4;
        }

        return 1;
    }
}
