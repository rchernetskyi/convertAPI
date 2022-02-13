package com.example.convertAPI.model.exceptions;

public class InvalidFormatException extends RuntimeException{
    public InvalidFormatException(String message) {
        super(String.format("Invalid %s file format", message));
    }

}
