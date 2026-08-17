package com.knightsnexus.cinenexus.exception;

public class ConflictException extends RuntimeException {

    public ConflictException(String message) {
        super(message);
    }
}

// Movie already exists in watchlist
// Movie already exists in custom lisst

// 409 Conflict