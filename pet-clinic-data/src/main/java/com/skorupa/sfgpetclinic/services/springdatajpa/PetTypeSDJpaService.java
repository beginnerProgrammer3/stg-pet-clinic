package com.skorupa.sfgpetclinic.services.springdatajpa;

import com.skorupa.sfgpetclinic.model.PetType;
import com.skorupa.sfgpetclinic.repositories.PetTypeRepository;
import com.skorupa.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")

public class PetTypeSDJpaService implements PetTypeService {

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    private final PetTypeRepository petTypeRepository;


    @Override
    public Set<PetType> findAll() {
        Set<PetType> pettypes = new HashSet<>();
        petTypeRepository.findAll().forEach(pettypes::add);

        return pettypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
