package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.Calculator;


@Singleton
public class InterestingService {

    @Inject GlobalAccountStorage globalAccountStorage;

    @Inject MoneyTransferService moneyTransferService;

    @Inject Calculator calc;

    public void run() {
        globalAccountStorage.bankAccounts.forEach(account -> {
            if (account instanceof SavingBankAccount) {

                double calculatedInterest = calc.Interest(account.getBalance());

                double afterTax = calculatedInterest * 0.85;

                moneyTransferService.addMoney(account, afterTax);
            }
        });
    }
}
