package com.koapti.lazychef.http.handler.users;

import com.koapti.lazychef.api.model.User;
import com.koapti.lazychef.model.mappers.api.UserApiMapper;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetUserDetailsHandler {

    private final UserRepository userRepository;

    public User handle(final String id) {
        com.koapti.lazychef.model.entity.User user = userRepository.getById(Integer.parseInt(id));
        return UserApiMapper.toApiUser(user);
    }
}
