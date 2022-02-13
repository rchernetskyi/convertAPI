package com.example.convertAPI.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidFormat(Exception exception) {
        return new ResponseEntity<>(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }
}
