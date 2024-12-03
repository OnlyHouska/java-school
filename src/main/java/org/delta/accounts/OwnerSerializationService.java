package org.delta.accounts;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class OwnerSerializationService {
    @Inject
    GlobalOwnerStorage globalOwnerStorage;

    @Inject
    SaveFileToFileSystemService saveFileToFileSystemService;

    @Inject
    IO io;

    public void runSerialization() {
        String fileName = "owners.json";
        Gson gson = new Gson();

        String finalJson = gson.toJson(globalOwnerStorage.getOwners());
        io.write(fileName, finalJson);

//        saveFileToFileSystemService.saveFile("owners.json", finalJson);
    }
}
