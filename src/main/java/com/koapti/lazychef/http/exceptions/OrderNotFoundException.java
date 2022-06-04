package com.koapti.lazychef.http.exceptions;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(final String error) {
        super(error);
    }
}
