package com.knightsnexus.cinenexus.exception;

public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String message) {
        super(message);
    }
}

// 401 : Who are you?
// 403 : I know who you are ? But u cannot do this : Forbidden 