package com.koapti.lazychef.http.handler.users;

import com.koapti.lazychef.model.dto.UserDto;
import com.koapti.lazychef.model.mappers.entity.UserEntityMapper;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateUserHandler {

    private final UserRepository userRepository;

    public void handle(final UserDto userDto) {
        userRepository.save(UserEntityMapper.toUserEntity(userDto));
    }
}
