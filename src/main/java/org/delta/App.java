package org.delta;

import org.delta.account.BankAccount;
import org.delta.account.MoneyTransferService;
import org.delta.persons.Owner;

public class App {
    public void Run() {
        this.testBank();
    }

    private void testBank() {
        MoneyTransferService moneyTransferService = new MoneyTransferService();

        Owner owner = new Owner("John", "Doe");
        BankAccount account = new BankAccount("123456", 500, owner);

        Owner owner2 = new Owner("Jane", "Doe");
        BankAccount account2 = new BankAccount("654321", 1000, owner2);

        moneyTransferService.TransferMoney(account, account2, 200);

        System.out.println("owner: " + owner.getFullName());
        moneyTransferService.addMoneyToBankAccount(account, 100);
    }
}
