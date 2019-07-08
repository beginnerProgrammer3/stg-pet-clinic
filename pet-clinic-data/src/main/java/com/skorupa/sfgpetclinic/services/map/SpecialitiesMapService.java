package com.skorupa.sfgpetclinic.services.map;

import com.skorupa.sfgpetclinic.model.Specialities;
import com.skorupa.sfgpetclinic.services.SpecialitiesService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile("asd")
public class SpecialitiesMapService extends AbstractMapService<Specialities, Long> implements SpecialitiesService {
    @Override
    public Set<Specialities> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialities object) {
        super.delete(object);
    }

    @Override
    public Specialities save(Specialities object) {
        return super.save(object);
    }

    @Override
    public Specialities findById(Long id) {
        return super.findById(id);
    }
}
