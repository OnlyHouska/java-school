package org.delta.acounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.cards.BankCard;
import org.delta.acounts.cards.BankCardFactory;
import org.delta.persons.Owner;

@Singleton
public class BankAccountFacade {

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private BankCardFactory bankCardFactory;

    @Inject
    private GlobalCardStorage globalCardStorage;

    @Inject
    private GlobalBankAccountStorage globalBankAccountStorage;

    public BankAccount createBankAccount(Owner owner, double balance, boolean withCard) {
        BankAccount account = this.bankAccountFactory.createBankAccount(owner, balance);
        this.globalBankAccountStorage.add(account);

        if (withCard) {
            BankCard card = this.bankCardFactory.createBankCard(account);
            account.addCard(card);
            this.globalCardStorage.addBankCard(card.getNumber(), account);
        }

        return account;
    }

    public BankAccount createStudentBankAccount(Owner owner, double balance, String expire) {
        BankAccount account = this.bankAccountFactory.createStudentBankAccount(owner, balance, expire);
        this.globalBankAccountStorage.add(account);

        return account;
    }

    public BankAccount createSavingBankAccount(Owner owner, double balance) {
        BankAccount account = this.bankAccountFactory.createSavingBankAccount(owner, balance);
        this.globalBankAccountStorage.add(account);

        return account;
    }
}
