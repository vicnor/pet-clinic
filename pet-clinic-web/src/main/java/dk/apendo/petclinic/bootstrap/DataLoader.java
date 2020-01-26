package dk.apendo.petclinic.bootstrap;

import dk.apendo.petclinic.model.Owner;
import dk.apendo.petclinic.model.Pet;
import dk.apendo.petclinic.model.PetType;
import dk.apendo.petclinic.model.Vet;
import dk.apendo.petclinic.services.OwnerService;
import dk.apendo.petclinic.services.PetService;
import dk.apendo.petclinic.services.PetTypeService;
import dk.apendo.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatType = petTypeService.save(cat);

        // Owner1
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Rosco");
        mikesPet.setBirthDate(LocalDate.now());

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        // Owner2
        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(cat);
        fionasPet.setOwner(owner1);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Frida");

        owner2.getPets().add(fionasPet);

        ownerService.save(owner2);

        // Vet1
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        // Vet2
        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);
    }
}
