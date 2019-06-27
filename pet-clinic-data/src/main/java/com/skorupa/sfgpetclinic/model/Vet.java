package com.skorupa.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Specialities> specialities = new HashSet<>();

    public Set<Specialities> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Specialities> specialities) {
        this.specialities = specialities;
    }
}
