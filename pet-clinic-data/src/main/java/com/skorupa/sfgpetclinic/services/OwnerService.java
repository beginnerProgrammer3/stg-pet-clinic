package com.skorupa.sfgpetclinic.services;

import com.skorupa.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String string);

    List<Owner> findAllByLastNameLike(String lastName);

}
