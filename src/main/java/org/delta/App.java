package org.delta;

import org.delta.acounts.*;
import org.delta.acounts.exceptions.NoMoneyOnAccountException;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;

import java.lang.annotation.Inherited;

public class App {

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

    private void testBank() throws Exception {

        AccountNumberGenerator bankAccountNumberGenerator = new SlovakiaBankAccountNumberGenerator();



        MoneyTransferService moneyTransferService = new MoneyTransferService();

        OwnerFactory ownerFactory = new OwnerFactory(bankAccountNumberGenerator);
        BankAccountFactory bankAccountFactory = new BankAccountFactory(bankAccountNumberGenerator);

        Owner owner = ownerFactory.createOwner("Tomas", "Pesek", "123");


        BankAccount accountOne = bankAccountFactory.createBankAccount(owner, 500);


        BankAccount accountTwo = bankAccountFactory.createStudentBankAccount(owner, 1500, "expirace");
        BankAccount accountThree = bankAccountFactory.createSavingBankAccount(owner, 1500);

        if (accountTwo instanceof StudentBankAccount) {
            String expire = ((StudentBankAccount) accountTwo).getStudentStudiesConfirmationExpire();
            System.out.println(expire);
        }

        if (accountThree instanceof Interesting) {
            double interest = ((Interesting) accountThree).getInterest();
            System.out.println(interest);
        }

        System.out.println("Bank account balance: " + accountOne.getBalance());

        moneyTransferService.addMoney(accountOne, 100);
        moneyTransferService.addMoney(accountOne, 10);
        moneyTransferService.addMoney(accountOne, 600);
        moneyTransferService.subMoney(accountOne, 150);

        moneyTransferService.transferMoneyBetweenAccounts(accountOne, accountTwo, 100);
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
}
