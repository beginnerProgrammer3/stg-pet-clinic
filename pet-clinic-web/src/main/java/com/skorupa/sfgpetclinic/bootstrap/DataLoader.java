package com.skorupa.sfgpetclinic.bootstrap;


import com.skorupa.sfgpetclinic.model.*;
import com.skorupa.sfgpetclinic.services.OwnerService;
import com.skorupa.sfgpetclinic.services.PetTypeService;
import com.skorupa.sfgpetclinic.services.SpecialitiesService;
import com.skorupa.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ovnerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ovnerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ovnerService = ovnerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }


    @Override
    public void run(String ...args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCat = petTypeService.save(dog);

        System.out.println("Loading Data!!!!");

        Owner owner1 = new Owner();
        owner1.setFirstName("Aneta");
        owner1.setLastName("Cabalska");
        owner1.setAddress(" przyjazni 55/57");
        owner1.setCity("Wroclaw");
        owner1.setTelephone("324-234-234");

        Pet anetaPet = new Pet();
        anetaPet.setPetType(saveDog);
        anetaPet.setOwner(owner1);
        anetaPet.setBirthDate(LocalDate.now());
        anetaPet.setName("Bobik");
        owner1.getPets().add(anetaPet);

        ovnerService.save(owner1);

        Specialities dentistry= new Specialities();
        dentistry.setDescription("Dentistry");
        Specialities saveDentistry = specialitiesService.save(dentistry);

        Specialities surgery = new Specialities();
        surgery.setDescription("Surgery");
        Specialities saveSurgery = specialitiesService.save(surgery);

        Specialities radiology = new Specialities();
        radiology.setDescription("Radiology");
        Specialities saveRadiology = specialitiesService.save(radiology);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mateusz");
        owner2.setLastName("Skorupa");
        owner2.setAddress("dęba 36");
        owner2.setCity("Poswietne");
        owner2.setTelephone("543-533-535");

        Pet matPet = new Pet();
        matPet.setName("Pimpkin");
        matPet.setOwner(owner2);
        matPet.setBirthDate(LocalDate.now());
        matPet.setPetType(saveCat);
        owner2.getPets().add(matPet);
        ovnerService.save(owner2);

        System.out.println("Loaded Owners....");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(saveRadiology);

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Smith");
        vet2.getSpecialities().add(saveDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
