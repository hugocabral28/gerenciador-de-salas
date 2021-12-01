package com.gerenciador.saladereuniao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

        ErrorDetais errorDetais = new ErrorDetais(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetais, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {

        ErrorDetais errorDetais = new ErrorDetais(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetais, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
