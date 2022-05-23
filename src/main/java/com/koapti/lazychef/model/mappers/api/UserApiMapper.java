package com.koapti.lazychef.model.mappers.api;

import com.koapti.lazychef.api.model.Role;
import com.koapti.lazychef.api.model.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserApiMapper {
    public static User toApiUser(final com.koapti.lazychef.model.entity.User user) {
        return User.builder()
                .id(user.getId())
                .login(user.getLogin())
                .name(user.getName())
                .password(user.getPassword())
                .role(Role.valueOf(user.getRole().name()))
                .surname(user.getSurname())
                .build();
    }
}
