package org.delta.account;

import java.text.MessageFormat;

public class MoneyTransferService {

    private static final double ADD_MONEY_FEE = 10.0;
    private static final double SECOND_LEVEL_FEE_LIMIT = 500.0;

    public void addMoneyToBankAccount(BankAccount account, double amount) {
//        double finalAmount = amount <= SECOND_LEVEL_FEE_LIMIT ? amount - ADD_MONEY_FEE : amount - (ADD_MONEY_FEE + amount * 0.01);
        double finalAmount = amount - ADD_MONEY_FEE - (amount > SECOND_LEVEL_FEE_LIMIT ? amount * 0.01 : 0);

        double finalFee = amount - finalAmount;

        account.setBalance(account.getBalance() + finalAmount);

        printTransferDetail(account);
    }

    public void TransferMoney(BankAccount account1, BankAccount account2, double amount) {
        if (account1.getBalance() < amount) {
            System.out.println("Not enough money in account: " + account1.getAccountNumber());
            return;
        }

        account1.setBalance(account1.getBalance() - amount);
        account2.setBalance(account2.getBalance() + amount);

        printTransferDetail(account1);
        printTransferDetail(account2);

        System.out.println(MessageFormat.format("Amount of {0} transferred successfully to account {1}", amount, account2.getAccountNumber()));
    }

    public void getMoneyFromBankAccount(BankAccount account, double amount) {
        account.setBalance(account.getBalance() - amount);

        printTransferDetail(account);
    }

    private void printTransferDetail(BankAccount account) {
        System.out.println("account: " + account.getAccountNumber() + ", balance: " + account.getBalance());
    }
}
