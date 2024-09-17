package org.delta.print;

import org.delta.acounts.BankAccount;

public class AccountDetailPrinter {

    public void printDetail(BankAccount account) {
        System.out.println("Bank account balance: " + account.getBalance());
    }

    public void printDetail(BankAccount account, double fee) {
        System.out.println("Bank account balance: " + account.getBalance() + ", fee " + fee);
    }

}
