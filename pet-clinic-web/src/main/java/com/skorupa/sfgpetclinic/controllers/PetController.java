package com.skorupa.sfgpetclinic.controllers;


import com.skorupa.sfgpetclinic.model.Owner;
import com.skorupa.sfgpetclinic.model.PetType;
import com.skorupa.sfgpetclinic.services.OwnerService;
import com.skorupa.sfgpetclinic.services.PetService;
import com.skorupa.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("owners/{ownerId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE = "pets/createorupdateform";

    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;


    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes(){
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable("ownerId") Long ownerId){
        return ownerService.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }


}
