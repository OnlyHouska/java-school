package org.delta.accounts;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BankAccountSerializationService {
    @Inject
    GlobalBankAccountStorage globalBankAccountStorage;

    @Inject
    SaveFileToFileSystemService saveFileToFileSystemService;

    public void runSerialization() {
        Gson gson = new Gson();

        Object finalJson = new Object();
        for (BankAccount bankAccount : globalBankAccountStorage.getBankAccounts()) {
            finalJson += gson.toJson(bankAccount);
        }

        System.out.println(finalJson);

        saveFileToFileSystemService.saveFile("bankAccounts.json", finalJson);
    }
}
