package com.hse;

public class InvalidBookingException extends Exception {

    public InvalidBookingException(String errorMessage){
        super(errorMessage);
    }
    
}
