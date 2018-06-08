package com.adrianapi.controller.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorDetails {

    private int statusCode;
    private HttpStatus status;
    private String error;
    private String message;

    public ErrorDetails() {

    }

    public ErrorDetails(int statusCode, HttpStatus status, String error, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
