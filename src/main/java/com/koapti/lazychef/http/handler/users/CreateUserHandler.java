package com.koapti.lazychef.http.handler.users;

import com.koapti.lazychef.api.model.User;
import com.koapti.lazychef.model.mappers.entity.UserEntityMapper;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateUserHandler {

    private final UserRepository userRepository;

    public String handle(final User user) {
        com.koapti.lazychef.model.entity.User save = userRepository.save(UserEntityMapper.toUserEntity(user));
        return save.getId().toString();
    }
}
