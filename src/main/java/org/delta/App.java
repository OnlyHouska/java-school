package org.delta;

import com.google.inject.Inject;
import org.delta.accounts.*;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;

public class App {

    public void run() throws Exception {
        this.testBank();
    }

    @Inject BankAccountFacade bankAccountFacade;

    @Inject OwnerFactory ownerFactory;

    @Inject MoneyTransferService moneyTransferService;

    @Inject BankCardFactory bankCardFactory;

    @Inject AtmService atmService;

    private void testBank() throws Exception {
        Owner owner = ownerFactory.createOwner("Tomas", "Pesek", "123");
        BankAccount accountOne = bankAccountFacade.createBankAccount(500, owner, true);
        BankAccount accountTwo = bankAccountFacade.createStudentBankAccount(1500, owner, false);
        BankAccount accountThree = bankAccountFacade.createSavingBankAccount(675, owner, true);

        // test
        if (accountTwo instanceof StudentBankAccount) {
            String expire = ((StudentBankAccount) accountTwo).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }

        if (accountThree instanceof Interesting) {
            double interest = ((Interesting) accountThree).getInterest();
            System.out.println(interest);
        }

        System.out.println("Bank account balance: " + accountOne.getBalance());

        atmService.withdrawMoney(accountOne.getCard("9999"), 100);
//        moneyTransferService.addMoney(accountOne, 100);
//        moneyTransferService.addMoney(accountOne, 10);
//        moneyTransferService.addMoney(accountOne, 600);
//        moneyTransferService.subMoney(accountOne, 150);

//        moneyTransferService.transferMoneyBetweenAccounts(accountOne, accountTwo, 100);
    }
}
