package com.koapti.lazychef.http.exceptions;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(final String error) {
        super(error);
    }
}
