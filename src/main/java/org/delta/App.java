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

    @Inject BankAccountFactory bankAccountFactory;

    @Inject OwnerFactory ownerFactory;

    @Inject MoneyTransferService moneyTransferService;

    @Inject BankCardFactory bankCardFactory;

    private void testBank() throws Exception {
        Owner owner = ownerFactory.createOwner("Tomas", "Pesek", "123");
        BankAccount accountOne = bankAccountFactory.createBankAccount(owner, 500);
        BankAccount accountTwo = bankAccountFactory.createStudentBankAccount(owner, 1500, "expirace");
        BankAccount accountThree = bankAccountFactory.createSavingBankAccount(owner, 1500);

        BankCard cardOne = bankCardFactory.createBankCard("1234");
        accountOne.assignNewCard(cardOne);

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

//        moneyTransferService.addMoney(accountOne, 100);
//        moneyTransferService.addMoney(accountOne, 10);
//        moneyTransferService.addMoney(accountOne, 600);
//        moneyTransferService.subMoney(accountOne, 150);

//        moneyTransferService.transferMoneyBetweenAccounts(accountOne, accountTwo, 100);
    }
}
