package org.delta.accounts;

import org.delta.persons.Owner;

public class StudentBankAccount extends BankAccount {

    private final String studentStudiesConfirmationExpire;

    public StudentBankAccount(double balance, Owner owner, String accountNumber) {
        super(accountNumber, balance, owner);

        this.studentStudiesConfirmationExpire = null;
    }

    public StudentBankAccount(double balance, Owner owner, String accountNumber, String studentStudiesConfirmationExpire) {
        super(accountNumber, balance, owner);

        this.studentStudiesConfirmationExpire = studentStudiesConfirmationExpire;
    }

    public String getStudentStudiesConfirmationExpire() {
        return studentStudiesConfirmationExpire;
    }
}
