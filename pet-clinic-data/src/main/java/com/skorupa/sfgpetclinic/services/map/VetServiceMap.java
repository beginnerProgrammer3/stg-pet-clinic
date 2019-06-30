package com.skorupa.sfgpetclinic.services.map;

import com.skorupa.sfgpetclinic.model.Specialities;
import com.skorupa.sfgpetclinic.model.Vet;
import com.skorupa.sfgpetclinic.services.SpecialitiesService;
import com.skorupa.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialitiesService specialitiesService;

    public VetServiceMap(SpecialitiesService specialitiesService) {
        this.specialitiesService = specialitiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
            super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
            super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(specialities -> {
                if (specialities.getId() == null) {
                    Specialities savedSpecialities = specialitiesService.save(specialities);
                    specialities.setId(savedSpecialities.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
