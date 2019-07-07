package com.skorupa.sfgpetclinic.services.springdatajpa;

import com.skorupa.sfgpetclinic.model.Specialities;
import com.skorupa.sfgpetclinic.repositories.SpecialitiesRepository;
import com.skorupa.sfgpetclinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class SpecialitiesSDJpaService implements SpecialitiesService {

    private final SpecialitiesRepository specialitiesRepository;

    public SpecialitiesSDJpaService(SpecialitiesRepository specialitiesRepository) {
        this.specialitiesRepository = specialitiesRepository;
    }

    @Override
    public Set<Specialities> findAll() {
        Set<Specialities> specialities = new HashSet<>();
        specialitiesRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Specialities findById(Long aLong) {
        return specialitiesRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialities save(Specialities object) {
        return specialitiesRepository.save(object);
    }

    @Override
    public void delete(Specialities object) {
        specialitiesRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialitiesRepository.findById(aLong);
    }
}
