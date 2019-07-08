package com.skorupa.sfgpetclinic.bootstrap;


import com.skorupa.sfgpetclinic.model.*;
import com.skorupa.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
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

        ownerService.save(owner1);
        Visit visit1 = new Visit();
        visit1.setPet(anetaPet);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("Aneta wizyta1");
        visitService.save(visit1);
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
        ownerService.save(owner2);

        Visit visit2 = new Visit();
        visit2.setPet(matPet);
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Mat wizyta1");
        visitService.save(visit2);

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
