package mwo.shop.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;
    private String name;
    private String surname;
    private String email;

    // Getters and setters

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;

    public Client(Long id, String name, String surname, String email) {
        this.client_id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Client(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Client(){

    }


    public Long getId() {
        return client_id;
    }

    public void setId(Long id) {
        this.client_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}