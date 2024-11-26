package org.delta.persons;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.AccountNumberGenerator;
import org.delta.accounts.GlobalOwnerStorage;

@Singleton
public class OwnerFactory {

    @Inject
    private PersonIdValidator personalIdValidator;

    @Inject
    private AccountNumberGenerator bankAccountNumberGenerator;

    @Inject
    private GlobalOwnerStorage globalOwnerStorage;

    public Owner createOwner(String name, String lastName, String personId) {

        if (!this.personalIdValidator.isPersonIdValid(personId)) {
            System.out.println("Invalid personId: " + personId);
        }

        System.out.println("Your bank account number can be like this: " + this.bankAccountNumberGenerator.generateBankAccountNumber());

        Owner owner = new Owner(name, lastName, personId);

        this.globalOwnerStorage.add(owner);
        return owner;
    }

}
