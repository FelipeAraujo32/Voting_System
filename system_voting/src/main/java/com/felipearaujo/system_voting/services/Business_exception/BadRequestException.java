package com.felipearaujo.system_voting.services.business_exception;

public class BadRequestException extends RuntimeException {
    
    public BadRequestException(String message) {
        super(message);
    }
    
}
