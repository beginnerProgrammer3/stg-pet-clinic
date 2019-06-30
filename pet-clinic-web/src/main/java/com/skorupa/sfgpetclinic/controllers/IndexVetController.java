package com.skorupa.sfgpetclinic.controllers;

import com.skorupa.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexVetController {

    private final VetService vetService;

    public IndexVetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets/index","/vets","/vets/index.html", "/vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());
        return "/vets/index";
    }
}
