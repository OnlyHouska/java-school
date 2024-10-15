package org.delta.accounts.cards;

import com.google.inject.Inject;

public class BankCardFactory {
    @Inject private CardNumberGenerator cardNumberGenerator;
    @Inject private BankCardPinGenerator bankCardPinGenerator;

    public BankCard createBankCard() {
        String number = this.cardNumberGenerator.generate();
        String pin = this.bankCardPinGenerator.generate();

        return new BankCard(number, pin);
    }


}
