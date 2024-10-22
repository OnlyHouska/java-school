package org.delta;

import com.google.inject.Inject;
import org.delta.acounts.*;
import org.delta.acounts.cards.BankCard;
import org.delta.persons.*;

import java.util.Map;

public class App {

    @Inject
    private PersonSerializationService personJsonSerializationService;

    @Inject
    private OwnerFactory ownerFactory;

    @Inject
    private BankAccountFacade bankAccountFacade;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private AtmService atmService;

    private void testBank() throws Exception {
        // DAOs
        Owner owner = this.ownerFactory.createOwner("Tomas", "Pesek", "123");

        BankAccount accountOne = this.bankAccountFacade.createBankAccount(owner, 500, true);
        BankAccount accountTwo = this.bankAccountFacade.createStudentBankAccount(owner, 1500, "expirace");
        BankAccount accountThree = this.bankAccountFacade.createSavingBankAccount(owner, 1500);

        System.out.println(this.personJsonSerializationService.serializeOwner(owner));

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

        this.moneyTransferService.addMoney(accountOne, 100);
        this.moneyTransferService.addMoney(accountOne, 10);
        this.moneyTransferService.addMoney(accountOne, 600);
        this.moneyTransferService.subMoney(accountOne, 150);

        this.moneyTransferService.transferMoneyBetweenAccounts(accountOne, accountTwo, 100);

        System.out.println();
        System.out.println("ATM SERVICE TEST");

        // hack
        BankCard bankCard = null;
        for (Map.Entry<String, BankCard> entrySet : accountOne.getCards().entrySet()) {
            bankCard = entrySet.getValue();
        }
        // hack

        this.atmService.withdrawMoney(bankCard.getNumber(), bankCard.getPin(), 500);
    }

    private void testNum() {
        int a = 10;
        int b = 10;
        System.out.println(a + b);
    }

    private void testStrings() {
        String text = "Toto je testovací řetězec";
        System.out.println(text.length());

        char searchChar = 'a';
        int counter = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == searchChar) {
                counter++;
            }
        }
        System.out.println("pocet a: " + counter);
    }

    private void testFor() {
        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    private void testCalc() {
        Calc calculator = new Calculator();

        System.out.println(calculator.add(10, 20));
        System.out.println(calculator.sub(10, 20));
        System.out.println(calculator.mul(10, 20));
        System.out.println(calculator.div(10, 0));
    }

    public void run() throws Exception {
        System.out.println("Hello and welcome!");

        this.testBank();

        /*
        this.testCalc();
        this.testStrings();
        this.testNum();
        this.testFor();
         */
    }
}
