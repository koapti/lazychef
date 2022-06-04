package com.koapti.lazychef.http.exceptions;

public class FoodAlreadyExistsException extends Exception {

    public FoodAlreadyExistsException(final String error) {
        super(error);
    }
}
