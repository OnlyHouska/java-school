package org.delta.accounts;

import com.google.inject.Singleton;
import org.delta.persons.Owner;

import java.util.LinkedList;
import java.util.List;

@Singleton
public class GlobalOwnerStorage {
    private final List<Owner> owners = new LinkedList<>();

    public void add(Owner owner) {
        this.owners.add(owner);
    }

    public List<Owner> getOwners() {
        return owners;
    }
}
