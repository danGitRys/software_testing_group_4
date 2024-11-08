package com;

public class InvalidBookingException extends Exception {

    public InvalidBookingException(String errorMessage){
        super(errorMessage);
    }
    
}
