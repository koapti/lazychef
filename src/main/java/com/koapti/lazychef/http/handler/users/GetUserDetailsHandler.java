package com.koapti.lazychef.http.handler.users;

import java.util.Optional;

import com.koapti.lazychef.api.model.Order;
import com.koapti.lazychef.api.model.User;
import com.koapti.lazychef.http.exceptions.OrderNotFoundException;
import com.koapti.lazychef.http.exceptions.UserNotFoundException;
import com.koapti.lazychef.model.mappers.api.OrderApiMapper;
import com.koapti.lazychef.model.mappers.api.UserApiMapper;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetUserDetailsHandler {

    private final UserRepository userRepository;

    public User handle(final String id) throws UserNotFoundException {
        Optional<com.koapti.lazychef.model.entity.User> user = userRepository.findById(Integer.parseInt(id));
        if (user.isPresent()) {
            return UserApiMapper.toApiUser(user.get());
        }
        throw new UserNotFoundException("User was not found");
    }
}