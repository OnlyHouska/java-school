package org.delta.persons;

import org.delta.acounts.AccountNumberGenerator;
import org.delta.acounts.BankAccountNumberGenerator;

public class OwnerFactory {

    private PersonIdValidator personalIdValidator;

    private AccountNumberGenerator bankAccountNumberGenerator;

    public OwnerFactory(AccountNumberGenerator bankAccountNumberGenerator, PersonIdValidator personalIdValidator) {
        this.personalIdValidator = personalIdValidator;
        this.bankAccountNumberGenerator = bankAccountNumberGenerator;
    }

    public Owner createOwner(String name, String lastName, String personId) {

        if (!this.personalIdValidator.isPersonIdValid(personId)) {
            System.out.println("Invalid personId: " + personId);
        }

        System.out.println("Your bank account number can be like this: " + this.bankAccountNumberGenerator.generateBankAccountNumber());

        return new Owner(name, lastName, personId);
    }

}
