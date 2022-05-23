package com.koapti.lazychef.http.handler.users;

import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class DeleteUserHandler {

    private final UserRepository userRepository;

    public void handle(final String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }
}
