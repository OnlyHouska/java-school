package org.delta.acounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.cards.BankCard;
import org.delta.acounts.exceptions.InvalidPinException;

@Singleton
public class AtmService {

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void withdrawMoney(String cardNumber, String pin, double amount) {
        BankAccount bankAccount = globalCardStorage.getBankAccount(cardNumber);
        BankCard bankCard = bankAccount.getCard(cardNumber);

        if (!bankCard.getPin().equals(pin)) {
            throw new InvalidPinException();
        }

        this.moneyTransferService.subMoney(bankAccount, amount);
    }

}
