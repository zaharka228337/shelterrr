package org.example;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shelters")
public class PetShelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "pet_nursery")
    private String nursery;
    @OneToMany(mappedBy = "shelter")
    private List<Pet> pets;
    @OneToMany(mappedBy = "shelter")
    private List<Request> requests;

    public PetShelter(String address, String nursery) {
        this.address = address;
        this.nursery = nursery;
        this.pets = new ArrayList<>();
        this.requests = new ArrayList<>();
    }

// Геттеры и сеттеры для атрибутов

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNursery() {
        return nursery;
    }

    public void setNursery(String nursery) {
        this.nursery = nursery;
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

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void removeRequest(Request request) {
        requests.remove(request);
    }
}
