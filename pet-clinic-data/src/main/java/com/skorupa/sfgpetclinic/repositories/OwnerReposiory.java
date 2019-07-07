package com.skorupa.sfgpetclinic.repositories;

import com.skorupa.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerReposiory extends CrudRepository<Owner, Long> {
    Owner findByLastName (String lastName);
    }
