package com.carRentalManager.exception;

public class CarClassNotFoundException extends RuntimeException{
    public CarClassNotFoundException(String message) {
        super(message);
    }
}
