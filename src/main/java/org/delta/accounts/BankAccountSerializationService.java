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

    @Inject
    IO io;

    public void runSerialization() {
        String fileName = "bankAccounts.json";
        Gson gson = new Gson();

        String finalJson = gson.toJson(globalBankAccountStorage.getBankAccounts());
        io.write(fileName, finalJson);


//        saveFileToFileSystemService.saveFile("bankAccounts.json", finalJson);
    }
}
