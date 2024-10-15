package org.delta.print;

import org.delta.accounts.BankAccount;

public interface DetailPrinter {
    void printDetail(BankAccount account);

    void printDetail(BankAccount account, double fee);
}
