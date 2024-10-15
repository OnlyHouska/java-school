package org.delta.print;

import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;

@Singleton
public class AccountDetailPrinter implements DetailPrinter {

    public void printDetail(BankAccount account) {
        System.out.println(PrinterUtils.getPrefix(account) + " Bank account balance: " + account.getBalance());
    }

    public void printDetail(BankAccount account, double fee) {
        System.out.println(PrinterUtils.getPrefix(account) + " Bank account balance: " + account.getBalance() + ", fee " + fee);
    }
}
