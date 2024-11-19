package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.exceptions.NoMoneyOnAccountException;
import org.delta.print.DetailPrinter;

@Singleton
public class MoneyTransferService {

    @Inject
    private TransferFeeCalculator transferFeeCalculator;

    @Inject
    private DetailPrinter accountDetailPrinter;

    public void addMoney(BankAccount account, double amount) {
        System.out.println("ADD money " + amount);
        double balance = account.getBalance();
        double fee = this.transferFeeCalculator.calculateFee(amount);

        double newBalance = balance + amount - fee;

        account.setBalance(newBalance);
        this.accountDetailPrinter.printDetail(account, fee);
    }

    public void subMoney(BankAccount account, double amount) {
        System.out.println("SUB money " + amount);
        this.accountDetailPrinter.printDetail(account);
        double balance = account.getBalance();
        double newBalance = balance - amount;

        account.setBalance(newBalance);
        this.accountDetailPrinter.printDetail(account);
    }

    public void transferMoneyBetweenAccounts(BankAccount from, BankAccount to, double amount) throws NoMoneyOnAccountException {
        System.out.println("MoneyTransferService::transferMoneyBetweenAccounts, amount: " + amount);

        if (from.getBalance() < amount) {
            throw new NoMoneyOnAccountException("Not money on account!");
        }

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);

        double sourceBalance = from.getBalance();
        double newSourceBalance = sourceBalance - amount;

        from.setBalance(newSourceBalance);
        double destinationBalance = to.getBalance();
        double newDestinationBalance = destinationBalance + amount;

        to.setBalance(newDestinationBalance);

        this.accountDetailPrinter.printDetail(from);
        this.accountDetailPrinter.printDetail(to);
    }
}
