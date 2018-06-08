package com.adrianapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> userNotFoundExceptionHandler(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setStatus(HttpStatus.NOT_FOUND);
        errorDetails.setError(ex.getMessage());
        errorDetails.setMessage("Please enter a valid id.");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyDatabaseException.class)
    public ResponseEntity<ErrorDetails> emptyDatabaseExceptionHandler(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NO_CONTENT.value());
        errorDetails.setStatus(HttpStatus.NO_CONTENT);
        errorDetails.setError(ex.getMessage());
        errorDetails.setMessage("Add a few users and try again.");
        return new ResponseEntity<>(errorDetails, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(UserDataException.class)
    public ResponseEntity<ErrorDetails> userDataExceptionHandler(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorDetails.setStatus(HttpStatus.BAD_REQUEST);
        errorDetails.setError(ex.getMessage());
        errorDetails.setMessage("Verify your fields names and avoid null values.");
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
