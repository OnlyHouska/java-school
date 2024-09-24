package org.delta.acounts;

import org.delta.persons.Owner;

public class BankAccountFactory {

    private AccountNumberGenerator bankAccountNumberGenerator;

    public BankAccountFactory(AccountNumberGenerator bankAccountNumberGenerator) {
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    public BankAccount createBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createBankAccount(Owner owner, double balance, String bankAccountNumber) {
        return new BankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createStudentBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentBankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createSavingBankAccount(Owner owner, double balance) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new SavingBankAccount(balance, owner, bankAccountNumber);
    }

    public BankAccount createStudentBankAccount(Owner owner, double balance, String studentStudiesConfirmationExpire) {
        String bankAccountNumber = this.bankAccountNumberGenerator.generateBankAccountNumber();

        return new StudentBankAccount(balance, owner, bankAccountNumber, studentStudiesConfirmationExpire);
    }
}
