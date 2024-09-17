package org.delta;

import org.delta.acounts.BankAccount;
import org.delta.acounts.MoneyTransferService;
import org.delta.persons.Owner;

public class App {

    public void run() {
        System.out.println("Hello and welcome!");

        this.testBank();

        /*
        this.testCalc();
        this.testStrings();
        this.testNum();
        this.testFor();
         */
    }

    private void testBank() {

        MoneyTransferService moneyTransferService = new MoneyTransferService();

        Owner owner = new Owner("Tomas", "Pesek");
        BankAccount account = new BankAccount(500, owner, "ABC123");

        System.out.println("Bank account balance: " + account.getBalance());

        moneyTransferService.addMoney(account, 100);
        moneyTransferService.addMoney(account, 10);
        moneyTransferService.addMoney(account, 600);
        moneyTransferService.subMoney(account, 150);
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
