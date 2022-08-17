package com.example.petapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Pet {

    private final UUID id;
    private String name;
    private int age;
    private String type;
    private String ownerName;

    public Pet() {
        this.id = UUID.randomUUID();
    }

    public Pet(String name, int age, String type, String ownerName) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.type = type;
        this.ownerName = ownerName;
    }
}

