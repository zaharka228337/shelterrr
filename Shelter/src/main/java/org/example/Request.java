package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "requests")
public class Request
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private String date;
    @Column(name = "status")
    private String status;
    @ManyToMany
    @JoinTable(name = "request_shelter", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "shelter_id"))
    private List<PetShelter> shelters;
    @ManyToMany
    @JoinTable(name = "request_pet", joinColumns = @JoinColumn(name = "request_id"), inverseJoinColumns = @JoinColumn(name = "pet_id"))
    private List<Pet> pets;

    public Request(String date, String status) {
        this.date = date;
        this.status = status;
        this.shelters = new ArrayList<>();
        this.pets = new ArrayList<>();
    }

// Геттеры и сеттеры для атрибутов

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
