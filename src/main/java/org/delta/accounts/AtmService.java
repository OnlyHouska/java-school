package org.delta.accounts;

import com.google.inject.Inject;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.exceptions.NoMoneyOnAccountException;

import java.util.Arrays;
import java.util.Scanner;

public class AtmService {
    @Inject
    MoneyTransferService moneyTransferService;

    @Inject
    GlobalCardStorage globalCardStorage;

    @Inject
    GlobalAccountStorage globalAccountStorage;

    public void withdrawMoney(BankCard bankCard, double amount) throws NoMoneyOnAccountException {
        BankAccount bankAccount = validateBankAccount(bankCard);

        if (bankAccount == null) {
            throw new IllegalArgumentException("With this card is not associated any bank account and/or it does not exist.");
        }
        if (bankAccount.getBalance() < amount) {
            throw new NoMoneyOnAccountException("Not enough money on account");
        }
        if (!validateAccess(bankCard)) {
            throw new IllegalArgumentException("Invalid pin");
        }

        System.out.println("You have withdrawn " + amount + " from your account");
        moneyTransferService.subMoney(bankAccount, amount);
    }

    private BankAccount validateBankAccount(BankCard bankCard) {
        return globalCardStorage.bankCards.getOrDefault(bankCard, null);
    }

    private boolean validateAccess(BankCard bankCard) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a card pin:");
        String enteredPin = scanner.nextLine();

        return bankCard.getPin().equals(enteredPin);
    }
}
