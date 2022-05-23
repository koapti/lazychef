package com.koapti.lazychef.http.handler.users;

import com.koapti.lazychef.api.model.User;
import com.koapti.lazychef.model.dto.UserDto;
import com.koapti.lazychef.model.mappers.entity.UserEntityMapper;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateUserHandler {

    private final UserRepository userRepository;

    public void handle(final User user) {
        userRepository.save(UserEntityMapper.toUserEntity(user));
    }
}
