package org.delta.accounts;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.delta.persons.Owner;

import java.lang.reflect.Type;
import java.util.List;

@Singleton
public class BankAccountDeserializationService {
    @Inject
    IO io;

    @Inject
    GlobalBankAccountStorage globalBankAccountStorage;

    public void run() {
        Gson gson = new Gson();
        String fileName = "bankAccounts.json";
        String json = io.read(fileName);

        Type bankAccountListType = new TypeToken<List<BankAccount>>() {}.getType();
        List<BankAccount> bankAccounts = gson.fromJson(json, bankAccountListType);

        if (bankAccounts == null) return;

        for (BankAccount bankAccount : bankAccounts) {
            globalBankAccountStorage.add(bankAccount);
        }
    }
}
