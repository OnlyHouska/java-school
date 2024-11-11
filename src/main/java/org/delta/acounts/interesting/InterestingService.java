package org.delta.acounts.interesting;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.BankAccount;
import org.delta.acounts.GlobalBankAccountStorage;
import org.delta.acounts.Interesting;

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
            if (!(account instanceof Interesting)) {
                continue;
            }

            Interesting interesting = (Interesting) account;
        }

        System.out.println("end interesting process");
    }

}
