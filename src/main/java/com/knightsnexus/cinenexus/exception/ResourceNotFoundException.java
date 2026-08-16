package com.knightsnexus.cinenexus.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

// Used when something requested does not exist.