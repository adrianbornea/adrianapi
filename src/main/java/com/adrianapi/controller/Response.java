package com.adrianapi.controller;

public class Response {
    private Integer userId;
    private String message;

    public Response(Integer id) {
        this.userId = id;
        this.message = "Customer Created Successfully";
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
