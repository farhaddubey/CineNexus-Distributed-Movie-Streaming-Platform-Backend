package com.knightsnexus.cinenexus.exception;

public class BugZones1 {

    public String letsDecode() {

//        String errorMessage = exception.getBindingResult()
//                .getAllError()  stream findFirst map orElse 
//                .get(0) // BUG ZONE
//                .getDefaultMessage(); // BUG ZONE


        // THE CORRECT VERSION
//        String errorMessage = exception.getBindingResult()
//                .getAllErrors()
//                .stream()
//                .findFirst()
//                .map(error -> error.getDefaultMessage())
//                .orElse("Validation failed");

        return "";
    }
}
