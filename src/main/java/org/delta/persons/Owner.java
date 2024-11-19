package org.delta.persons;

import com.google.gson.annotations.SerializedName;

public class Owner{

    private final String name;

    private final String surname;

    private final String personId;

    public Owner(String name, String surname, String personId) {
        this.name = name;
        this.surname = surname;
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonId() {
        return personId;
    }
}