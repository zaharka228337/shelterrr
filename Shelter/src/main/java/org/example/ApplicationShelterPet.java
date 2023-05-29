package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class ApplicationShelterPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private PetShelter shelter;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public ApplicationShelterPet(Request request, PetShelter shelter, Pet pet) {
        this.request = request;
        this.shelter = shelter;
        this.pet = pet;
    }

// Геттеры и сеттеры для атрибутов

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public PetShelter getShelter() {
        return shelter;
    }

    public void setShelter(PetShelter shelter) {
        this.shelter = shelter;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
