package dk.apendo.petclinic.services.jpa;

import dk.apendo.petclinic.model.Specialty;
import dk.apendo.petclinic.repositories.SpecialtyRepository;
import dk.apendo.petclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

public class SpecialtyJpaService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {

        HashSet<Specialty> specialties = new HashSet<>();

        specialtyRepository.findAll().forEach(specialties::add);

        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
