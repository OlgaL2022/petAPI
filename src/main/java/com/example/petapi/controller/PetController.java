package com.example.petapi.controller;

import com.example.petapi.model.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class PetController {

    private final ArrayList<Pet> pets = new ArrayList<>();

    /*Read*/
    @GetMapping("/api/pets")
    public ArrayList<Pet> getPets() {
        return pets;
    }

    /*Create*/
    @PostMapping("/api/pets")
    public Pet createPet(@RequestBody Pet petRequest) {
        Pet pet = new Pet(
                petRequest.getName(),
                petRequest.getAge(),
                petRequest.getType(),
                petRequest.getOwnerName()
        );
        pets.add(pet);
        return pet;
    }

    /*Update/Replace*/
    @PutMapping("/api/pets/{id}")
    public Pet updatePet(@RequestBody Pet updatedPet) {
        for (Pet pet : pets) {
            if (pet.getId().equals(updatedPet.getId())) {
                pet.setName(updatedPet.getName());
                pet.setAge(updatedPet.getAge());
                pet.setType(updatedPet.getType());
                pet.setOwnerName(updatedPet.getOwnerName());
                return pet;
            }
        }
        return null;
    }

    /*Delete*/
    @DeleteMapping("/api/pets/{id}")
    public Boolean deletePet(@PathVariable UUID id) {
        for (Pet pet : pets) {
            if (pet.getId().equals(id)) {
                return pets.remove(pet);
            }
        }
        return false;
    }

    /*@PathVariable to send the pet id to receive single pet information in GET request*/
    @GetMapping("/api/pets/{id}")
    public String getPet(@PathVariable UUID id) {
        return pets.stream()
                .filter(pet -> pet.getId().equals(id))
                .findAny()
                .map(pet -> "Pet is found: " + pet)
                .orElse("Pet not found");
    }
}



