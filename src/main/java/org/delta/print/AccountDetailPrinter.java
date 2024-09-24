package org.delta.print;

import org.delta.acounts.BankAccount;
import org.delta.acounts.StudentBankAccount;

public class AccountDetailPrinter {

    public void printDetail(BankAccount account) {
        System.out.println(this.getPrefix(account) + " Bank account balance: " + account.getBalance());
    }

    public void printDetail(BankAccount account, double fee) {
        System.out.println(this.getPrefix(account) + " Bank account balance: " + account.getBalance() + ", fee " + fee);
    }

    private String getPrefix(BankAccount account) {
        if (account instanceof StudentBankAccount) {
            return "Student ";
        }

        return "";
    }

}
