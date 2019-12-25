package dk.apendo.petclinic.services.map;

import dk.apendo.petclinic.model.Pet;
import dk.apendo.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapServcie<Pet, Long> implements CrudService<Pet, Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
