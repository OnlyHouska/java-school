package org.delta.accounts;

import com.google.gson.Gson;
import com.google.inject.Singleton;

import java.io.FileWriter;
import java.io.IOException;

@Singleton
public class SaveFileToFileSystemService {
    public void saveFile(String fileName, Object fileContent) {
        try {
            Gson gson = new Gson();
            gson.toJson(fileContent, new FileWriter(fileName));
        } catch (IOException e) {
            //throw errors
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
