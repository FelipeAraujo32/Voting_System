package com.felipearaujo.system_voting.services.business_exception;

public class ValidationExceptionBusiness extends RuntimeException{
    
    public ValidationExceptionBusiness(String message) {
        super(message);
    }
}
