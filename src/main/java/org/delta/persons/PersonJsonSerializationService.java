package org.delta.persons;

public class PersonJsonSerializationService {
    public String serializeOwner(Owner owner) {
        return "{\n" +
                "    \"name\": \"" + owner.getName() + "\",\n" +
                "    \"surname\": \"" + owner.getSurname() + "\",\n" +
                "    \"personId\": \"" + owner.getPersonId() + "\"\n" +
                "}";

    }
}