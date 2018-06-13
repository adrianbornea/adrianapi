package com.adrianapi.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String auUser;
    private String auPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuUser() {
        return auUser;
    }

    public void setAuUser(String auUser) {
        this.auUser = auUser;
    }

    public String getAuPassword() {
        return auPassword;
    }

    public void setAuPassword(String auPassword) {
        this.auPassword = auPassword;
    }
}
