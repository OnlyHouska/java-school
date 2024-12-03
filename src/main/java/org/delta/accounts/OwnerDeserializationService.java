package org.delta.accounts;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.delta.persons.Owner;

import java.lang.reflect.Type;
import java.util.List;

@Singleton
public class OwnerDeserializationService {
    @Inject
    IO io;

    @Inject
    GlobalOwnerStorage globalOwnerStorage;

    public void run() {
        Gson gson = new Gson();
        String fileName = "owners.json";
        String json = io.read(fileName);

        Type ownerListType = new TypeToken<List<Owner>>() {}.getType();
        List<Owner> owners = gson.fromJson(json, ownerListType);

        if (owners == null) return;

        for (Owner owner : owners) {
            globalOwnerStorage.add(owner);
        }
    }
}
