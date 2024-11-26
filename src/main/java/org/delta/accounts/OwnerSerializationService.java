package org.delta.accounts;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.persons.Owner;

@Singleton
public class OwnerSerializationService {
    @Inject
    GlobalOwnerStorage globalOwnerStorage;

    @Inject
    SaveFileToFileSystemService saveFileToFileSystemService;

    public void runSerialization() {
        Gson gson = new Gson();

        Object finalJson = new Object();

        for (Owner owner : globalOwnerStorage.getOwners()) {
            finalJson += gson.toJson(owner, Owner.class);
        }

        saveFileToFileSystemService.saveFile("owners.json", finalJson);
    }
}
