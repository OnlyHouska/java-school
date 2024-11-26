package org.delta.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Singleton;
import org.delta.persons.Owner;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Singleton
public class LoadFileFromFileSystem {
    public List<Owner> loadOwners(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, Owner.class));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load owners from file: " + fileName, e);
        }
    }

    public List<BankAccount> loadBankAccounts(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fileName), objectMapper.getTypeFactory().constructCollectionType(List.class, BankAccount.class));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load bank accounts from file: " + fileName, e);
        }
    }
}
