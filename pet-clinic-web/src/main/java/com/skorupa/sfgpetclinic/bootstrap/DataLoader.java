package com.skorupa.sfgpetclinic.bootstrap;


import com.skorupa.sfgpetclinic.model.Owner;
import com.skorupa.sfgpetclinic.model.Vet;
import com.skorupa.sfgpetclinic.services.OwnerService;
import com.skorupa.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ovnerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ovnerService, VetService vetService) {
        this.ovnerService = ovnerService;
        this.vetService = vetService;
    }



    @Override
    public void run(String... args) throws Exception {
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
