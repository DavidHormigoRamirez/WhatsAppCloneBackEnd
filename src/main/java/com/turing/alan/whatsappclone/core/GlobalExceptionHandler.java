package com.turing.alan.whatsappclone.core;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleUserExists(UserAlreadyExistsException ex) {
        return new ResponseEntity<ErrorMessage>(new ErrorMessage("el usuario ya existe"),HttpStatus.NOT_ACCEPTABLE);
    
    }

    @ExceptionHandler(NoSuchElementException.class) 
    public ResponseEntity<ErrorMessage> handleDoesNotExists(NoSuchElementException ex) {
        return new ResponseEntity<>(new ErrorMessage("El elemento no existe"),HttpStatus.NOT_FOUND);
    }
}
