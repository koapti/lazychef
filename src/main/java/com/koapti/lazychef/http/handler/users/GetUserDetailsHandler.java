package com.koapti.lazychef.http.handler.users;

import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetUserDetailsHandler {

    private final UserRepository userRepository;

    public String handle(final String id) {
        return null;
    }
}
