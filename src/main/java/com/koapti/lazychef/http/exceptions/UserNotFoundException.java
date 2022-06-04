package com.koapti.lazychef.http.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(final String error) {
        super(error);
    }
}
