package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.exceptions.InvalidPinException;

@Singleton
public class AtmService {

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private MoneyTransferService moneyTransferService;

    public void withdrawMoney(String cardNumber, String pin, double amount) {
//        BankAccount bankAccount = globalCardStorage.getBankAccount(cardNumber);
//        if (bankAccount == null) {
//            throw new IllegalArgumentException("Card not found");
//        }
//        BankCard bankCard = bankAccount.getCard(cardNumber);
//
//        if (!bankCard.getPin().equals(pin)) {
//            throw new InvalidPinException();
//        }
//
//        this.moneyTransferService.subMoney(bankAccount, amount);
    }

}
