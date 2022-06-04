package com.koapti.lazychef.http.exceptions;

public class FoodNotFoundException extends Exception {

    public FoodNotFoundException(final String error) {
        super(error);
    }
}
