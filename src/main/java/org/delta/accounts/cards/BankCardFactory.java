package org.delta.accounts.cards;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.BankAccount;
import org.delta.accounts.GlobalCardStorage;

@Singleton
public class BankCardFactory {

    @Inject
    private CardNumberGenerator cardNumberGenerator;

    @Inject
    private BankCardPinGenerator bankCardPinGenerator;

    public BankCard createBankCard(BankAccount bankAccount) {
        BankCard bankCard = new BankCard(
            this.cardNumberGenerator.generate(),
            this.bankCardPinGenerator.generate(),
            bankAccount
        );

        return bankCard;
    }
}
