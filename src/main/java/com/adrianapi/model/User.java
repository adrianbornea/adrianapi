package com.adrianapi.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    // ===========================
    // FIELDS
    // ===========================

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;
    public String password;
    public String email;

    public User() {

    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }


    // ===========================
    // OVERRIDDEN METHODS
    // ===========================

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // ===========================
    // GETTERS AND SETTERS
    // ===========================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}



