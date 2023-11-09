package mwo.shop.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

public class Client {
    private Long client_id;
    private String name;
    private String surname;
    private String email;

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
}
