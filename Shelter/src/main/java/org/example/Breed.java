package org.example;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "breeds")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "breed")
    private List<Pet> pets;

    public Breed(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

// Геттеры и сеттеры для атрибутов

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

// Методы для работы со списком питомцев

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }
}
