package com.skorupa.sfgpetclinic.services.springdatajpa;

import com.skorupa.sfgpetclinic.model.Owner;
import com.skorupa.sfgpetclinic.repositories.OwnerReposiory;
import com.skorupa.sfgpetclinic.repositories.PetRepository;
import com.skorupa.sfgpetclinic.repositories.PetTypeRepository;
import com.skorupa.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerReposiory ownerReposiory;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;


    public OwnerSDJpaService(OwnerReposiory ownerReposiory, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerReposiory = ownerReposiory;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerReposiory.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerReposiory.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
//    Optional<Owner> optionalOwner = ownerReposiory.findById(aLong);

//    if(optionalOwner.isPresent()){
//        return optionalOwner.get();
//    }else{
//        return null;
//    }
    //Ta sama metoda napisana o wiele krocej
        return ownerReposiory.findById(aLong).orElse(null);

    }

    @Override
    public Owner save(Owner object) {
        return ownerReposiory.save(object);

    }

    @Override
    public void delete(Owner object) {
        ownerReposiory.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerReposiory.deleteById(aLong);
    }
}
