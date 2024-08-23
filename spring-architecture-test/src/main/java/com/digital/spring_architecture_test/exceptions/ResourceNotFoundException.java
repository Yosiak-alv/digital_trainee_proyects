package com.digital.spring_architecture_test.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
