package com.adrianapi.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDataException extends RuntimeException {
    public UserDataException(String message) {
        super(message);
    }
}

