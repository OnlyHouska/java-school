package org.delta.print;

import org.delta.accounts.BankAccount;
import org.delta.accounts.SavingBankAccount;
import org.delta.accounts.StudentBankAccount;

public class PrinterUtils {
    private PrinterUtils() {}

    public static String getPrefix(BankAccount account) {
        if (account instanceof StudentBankAccount) {
            return "Student ";
        }

        if (account instanceof SavingBankAccount) {
            return "Saving ";
        }

        return "";
    }
}
