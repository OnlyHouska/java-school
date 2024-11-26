package org.delta.persons;

import com.google.gson.annotations.SerializedName;

public class Owner{

    private final String name;

    private final String surname;

    @SerializedName("person_id")
    private final String s256b_personId;

    public Owner(String name, String surname, String personId) {
        this.name = name;
        this.surname = surname;
        this.s256b_personId = personId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getS256b_personId() {
        return s256b_personId;
    }
}