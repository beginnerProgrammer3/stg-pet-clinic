package com.skorupa.sfgpetclinic.repositories;

import com.skorupa.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
