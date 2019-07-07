package com.skorupa.sfgpetclinic.repositories;

import com.skorupa.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
