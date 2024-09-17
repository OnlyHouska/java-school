package org.delta.acounts;

import org.delta.print.AccountDetailPrinter;

public class MoneyTransferService {

    private final TransferFeeCalculator transferFeeCalculator;
    private final AccountDetailPrinter accountDetailPrinter;

    public MoneyTransferService() {
        this.transferFeeCalculator = new TransferFeeCalculator();
        this.accountDetailPrinter = new AccountDetailPrinter();
    }

    public void addMoney(BankAccount account, double amount) {
        double balance = account.getBalance();
        double fee = this.transferFeeCalculator.calculateFee(amount);

        double newBalance = balance + amount - fee;

        account.setBalance(newBalance);
        this.accountDetailPrinter.printDetail(account, fee);
    }

    public void subMoney(BankAccount account, double amount) {
        double balance = account.getBalance();
        double newBalance = balance - amount;

        account.setBalance(newBalance);
        this.accountDetailPrinter.printDetail(account);
    }
}
