package org.delta.persons;

import com.google.inject.Singleton;

@Singleton
public class PersonIdValidator implements IPersonIdValidator {

    public boolean isPersonIdValid(String personId) {
        return true;
    }

}
