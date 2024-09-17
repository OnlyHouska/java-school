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

        System.out.println("owner: " + owner.getFullName());
        moneyTransferService.addMoneyToBankAccount(account, 100);
    }
}
