package org.delta.accounts;

import com.google.inject.Singleton;

import javax.xml.stream.events.StartDocument;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@Singleton
public class IO {
    public void write(String fileName, String content) {
        List<String> parsedContent = Collections.singletonList(content);

        Path file = Paths.get(fileName);

        try {
            Files.write(file, parsedContent, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String read(String fileName) {
        Path file = Paths.get(fileName);

        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
