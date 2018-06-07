package com.adrianapi.controller;

public class DeletingResponse {
    private int id;
    private final String MESSAGE = "User successfully deleted from the database!";

    public DeletingResponse(Integer id) {
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
