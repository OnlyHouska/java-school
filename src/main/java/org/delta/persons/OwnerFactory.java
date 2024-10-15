package org.delta.persons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.AccountNumberGenerator;

@Singleton
public class OwnerFactory {

    @Inject
    private PersonIdValidator personalIdValidator;

    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;

    public Owner createOwner(String name, String lastName, String personId) {

        if (!this.personalIdValidator.isPersonIdValid(personId)) {
            System.out.println("Invalid personId: " + personId);
        }

        System.out.println("Your bank account number can be like this: " + this.bankAccountNumberGenerator.generateBankAccountNumber());

        return new Owner(name, lastName, personId);
    }

}
