package org.example;
import java.util.ArrayList;
import java.util.List;

public abstract class DataStorage {
    private List<Breed> breeds;
    private List<PetShelter> shelters;
    private List<Pet> pets;
    private List<ApplicationShelterPet> applications;
    private List<User> users;
    private List<Request> requests;

    public DataStorage() {
        breeds = new ArrayList<>();
        shelters = new ArrayList<>();
        pets = new ArrayList<>();
        applications = new ArrayList<>();
        users = new ArrayList<>();
        requests = new ArrayList<>();
    }

// Методы для работы с породами

    public void addBreed(Breed breed) {
        breeds.add(breed);
    }

    public void removeBreed(Breed breed) {
        breeds.remove(breed);
    }

    public List<Breed> getBreeds() {
        return breeds;
    }

// Методы для работы с приютами

    public void addShelter(PetShelter shelter) {
        shelters.add(shelter);
    }

    public void removeShelter(PetShelter shelter) {
        shelters.remove(shelter);
    }

    public List<PetShelter> getShelters() {
        return shelters;
    }

// Методы для работы с питомцами

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public List<Pet> getPets() {
        return pets;
    }

// Методы для работы с заявками на приют и питомцев

    public void addApplication(ApplicationShelterPet application) {
        applications.add(application);
    }

    public void removeApplication(ApplicationShelterPet application) {
        applications.remove(application);
    }

    public List<ApplicationShelterPet> getApplications() {
        return applications;
    }

// Методы для работы с пользователями

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

// Методы для работы с заявками

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void removeRequest(Request request) {
        requests.remove(request);
    }

    public List<Request> getRequests() {
        return requests;
    }
}
