package org.delta.persons;

import com.google.inject.Singleton;

@Singleton
public class PersonJsonSerializationService implements PersonSerializationService {
    public String serializeOwner(Owner owner) {
        StringBuilder builder = new StringBuilder();

        builder.append("{");
        builder.append("\"name\": ");
        builder.append("\"" + owner.getName() + "\", ");

        builder.append("\"lastName\": ");
        builder.append("\"" + owner.getSurname() + "\", ");

        builder.append("\"personId\": ");
        builder.append("\"" + owner.getPersonId() + "\" ");

        builder.append("}");

        return builder.toString();
    }
}
