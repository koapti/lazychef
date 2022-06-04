package com.koapti.lazychef.http.service;

import java.util.Optional;

import com.koapti.lazychef.model.entity.User;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class UserService {

    private final UserRepository userRepository;

    public boolean isUserAlreadyExists(final String login) {
        return checkUser(login);
    }

    private boolean checkUser(final String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return user.isPresent();
    }
}
