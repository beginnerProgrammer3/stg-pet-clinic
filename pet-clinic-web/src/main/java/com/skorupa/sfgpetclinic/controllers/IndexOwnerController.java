package com.skorupa.sfgpetclinic.controllers;

import com.skorupa.sfgpetclinic.model.Owner;
import com.skorupa.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class IndexOwnerController {

    private static final String VIEWS_OWNER_OR_UPDATE = "owners/createorupdateownerform";

    private final OwnerService ownerService;

    public IndexOwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    //wazne zeby nikt nie namieszal w bazie danych
//    @InitBinder
//    public void setAllowedFields(WebDataBinder dataBinder){
//        dataBinder.setDisallowedFields("id");
//    }

    @RequestMapping({"/","","/index","/index.html"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> resultsList = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
        resultsList.forEach(owner1 -> {System.out.println(owner1.getLastName());
            System.out.println(owner1.getFirstName());});
        if (resultsList.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
       }else if  (resultsList.size() == 1) {
            // 1 owner found
            owner = resultsList.get(0);
            System.out.println(owner.getLastName());
            return "redirect:/owners/" + owner.getId();
        }
        else {
            // multiple owners found
            model.addAttribute("selections", resultsList);
            return "owners/ownersList";
    }}

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        Owner owner = Owner.builder().build();
        model.addAttribute("owner", owner);
        return VIEWS_OWNER_OR_UPDATE;
    }
    @PostMapping("/new")
    public String processCreationForm(@Valid Owner owner, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return VIEWS_OWNER_OR_UPDATE;
        }else {
            Owner savedOwner =ownerService.save(owner);
            return "redirect:/owners/"+ savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable ("{ownerId}") Long ownerId, Model model){

        model.addAttribute("owner", ownerService.findById(ownerId));
        return VIEWS_OWNER_OR_UPDATE;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(@Valid Owner owner, BindingResult bindingResult, @PathVariable Long ownerId){
        if(bindingResult.hasErrors()){
            return VIEWS_OWNER_OR_UPDATE;
        }else{
            owner.setId(ownerId);
            Owner editedOvner = ownerService.save(owner);
            return "redirect:/owners/" +editedOvner.getId();
        }
    }
}
