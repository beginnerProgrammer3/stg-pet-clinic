package com.skorupa.sfgpetclinic.services.springdatajpa;

import com.skorupa.sfgpetclinic.model.Owner;
import com.skorupa.sfgpetclinic.repositories.OwnerRepository;
import com.skorupa.sfgpetclinic.repositories.PetRepository;
import com.skorupa.sfgpetclinic.repositories.PetTypeRepository;
import com.skorupa.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerReposiory;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;


    public OwnerSDJpaService(OwnerRepository ownerReposiory, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerReposiory = ownerReposiory;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
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
        System.out.println("## ## ## ###");
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

    @Override
    public Owner findByLastName(String string) {
        return ownerReposiory.findByLastName(string);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerReposiory.findAllByLastNameLike(lastName);
    }
}
