package com.adrianapi.controller;

public class AddingResponse {
    private int id;
    private final String MESSAGE = "User successfully added to the database!";
    public AddingResponse(Integer id) {
                this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
}
