package org.delta.accounts.interesting;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalBankAccountStorage;
import org.delta.accounts.Interesting;
import org.delta.accounts.InterestingBankAccount;

@Singleton
public class InterestingService {

    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    private InterestingCalculator interestingCalculator;

    public void run() {
        System.out.println("start interesting process");

        if (globalBankAccountStorage.getBankAccounts().isEmpty()) {
            return;
        }

        for (BankAccount account : globalBankAccountStorage.getBankAccounts()) {
            if (!(account instanceof InterestingBankAccount)) {
                continue;
            }

//            InterestingBankAccount interesting = (InterestingBankAccount) account;
        }

        System.out.println("end interesting process");
    }

}
