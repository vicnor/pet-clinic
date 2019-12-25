package dk.apendo.petclinic.services;

import dk.apendo.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
