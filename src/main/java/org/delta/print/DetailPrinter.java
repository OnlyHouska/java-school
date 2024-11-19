package org.delta.print;

import com.google.inject.Inject;
import org.delta.accounts.BankAccount;

public interface DetailPrinter {
    public void printDetail(BankAccount account);

    public void printDetail(BankAccount account, double fee);
}
