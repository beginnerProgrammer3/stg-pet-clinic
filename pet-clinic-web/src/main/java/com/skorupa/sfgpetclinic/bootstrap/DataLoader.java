package com.skorupa.sfgpetclinic.bootstrap;


import com.skorupa.sfgpetclinic.model.Owner;
import com.skorupa.sfgpetclinic.model.PetType;
import com.skorupa.sfgpetclinic.model.Vet;
import com.skorupa.sfgpetclinic.services.OwnerService;
import com.skorupa.sfgpetclinic.services.PetTypeService;
import com.skorupa.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ovnerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ovnerService, VetService vetService, PetTypeService petTypeService) {
        this.ovnerService = ovnerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String ...args) throws Exception {
            PetType dog = new PetType();
            dog.setName("Dog");
            PetType saveDog = petTypeService.save(dog);

            PetType cat = new PetType();
            cat.setName("Cat");
            PetType saveCat = petTypeService.save(dog);

            Owner owner1 = new Owner();
            owner1.setFirstName("Aneta");
            owner1.setLastName("Cabalska");
            ovnerService.save(owner1);


            Owner owner2 = new Owner();
            owner2.setFirstName("Mateusz");
            owner2.setLastName("Skorupa");
            ovnerService.save(owner2);

            System.out.println("Loaded Owners....");


            Vet vet1 = new Vet();
            vet1.setFirstName("Sam");
            vet1.setLastName("Axe");
            vetService.save(vet1);


            Vet vet2 = new Vet();
            vet2.setFirstName("John");
            vet2.setLastName("Smith");

            vetService.save(vet2);

            System.out.println("Loaded Vets.....");




    }
}
