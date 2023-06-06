package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_address")
    private String address;
    @Column(name = "salary")
    private String salary;
    @Column(name = "phone")
    private String phone;
    @OneToMany(mappedBy = "user")
    private List<Request> requests; // Список заявок

    public User(String name, String address, String salary, String phone) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.phone = phone;
    }

    public User(){

    }

// Геттеры и сеттеры для атрибутов

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
