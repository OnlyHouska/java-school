package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFacade {
    @Inject
    private GlobalAccountStorage globalAccountStorage;

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private BankCardFactory bankCardFactory;

    public BankAccount createBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount bankAccount = bankAccountFactory.createBankAccount(owner, balance);
        globalAccountStorage.save(bankAccount);

        if (withCard) {
            BankCard bankCard = bankCardFactory.createBankCard();
            bankAccount.assignNewCard(bankCard);
            globalCardStorage.save(bankAccount, bankCard);
        }

        return bankAccount;
    }

    public BankAccount createStudentBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount bankAccount =  bankAccountFactory.createStudentBankAccount(owner, balance);
        globalAccountStorage.save(bankAccount);

        if (withCard) {
            BankCard bankCard = bankCardFactory.createBankCard();
            bankAccount.assignNewCard(bankCard);
            globalCardStorage.save(bankAccount, bankCard);
        }

        return bankAccount;
    }

    public BankAccount createSavingBankAccount(double balance, Owner owner, boolean withCard) {
        BankAccount bankAccount = bankAccountFactory.createSavingBankAccount(owner, balance);
        globalAccountStorage.save(bankAccount);

        if (withCard) {
            BankCard bankCard = bankCardFactory.createBankCard();
            bankAccount.assignNewCard(bankCard);
            globalCardStorage.save(bankAccount, bankCard);
        }

        return bankAccount;
    }
}
