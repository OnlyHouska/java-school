package org.delta.account;

public class MoneyTransferService {

    private static final double ADD_MONEY_FEE = 10.0;
    private static final double SECOND_LEVEL_FEE_LIMIT = 500.0;

    public void addMoneyToBankAccount(BankAccount account, double amount) {
//        double finalAmount = amount <= SECOND_LEVEL_FEE_LIMIT ? amount - ADD_MONEY_FEE : amount - (ADD_MONEY_FEE + amount * 0.01);
        double finalAmount = amount - ADD_MONEY_FEE - (amount > SECOND_LEVEL_FEE_LIMIT ? amount * 0.01 : 0);

        double finalFee = amount - finalAmount;

        account.setBalance(account.getBalance() + finalAmount);

        printTrasnferDetail(account);
    }

    public void getMoneyFromBankAccount(BankAccount account, double amount) {
        account.setBalance(account.getBalance() - amount);

        printTrasnferDetail(account);
    }

    private void printTrasnferDetail(BankAccount account) {
        System.out.println("account: " + account.getAccountNumber() + ", balance: " + account.getBalance());
    }
}
