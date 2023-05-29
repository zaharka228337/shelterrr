package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "age")
    private int age;
    @ManyToOne
    @JoinColumn(name = "breed_id")
    private Breed breed;
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private List<PetShelter> shelters;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private List<Request> requests;

    public Pet(String name, String description, int age, Breed breed) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.breed = breed;
        this.shelters = new ArrayList<>();
        this.requests = new ArrayList<>();
    }

// Геттеры и сеттеры для атрибутов

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

// Методы для работы со списком приютов

    public List<PetShelter> getShelters() {
        return shelters;
    }

    public void addShelter(PetShelter shelter) {
        shelters.add(shelter);
    }

    public void removeShelter(PetShelter shelter) {
        shelters.remove(shelter);
    }

// Методы для работы со списком заявок

    public List<Request> getRequests() {
        return requests;
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void removeRequest(Request request) {
        requests.remove(request);
    }

    public Breed getBreed() {
        return null;
    }
}
