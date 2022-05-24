package com.koapti.lazychef.http.handler.users;

import java.util.List;
import java.util.stream.Collectors;

import com.koapti.lazychef.api.model.UsersList;
import com.koapti.lazychef.model.entity.User;
import com.koapti.lazychef.model.mappers.api.UserApiMapper;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class GetUsersHandler {

    private final UserRepository userRepository;

    public UsersList handle() {
        List<User> allUsers = userRepository.findAll();

        return UsersList.of(allUsers.stream().map(UserApiMapper::toApiUser).collect(Collectors.toList()));
    }
}
