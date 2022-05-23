package com.koapti.lazychef.model.mappers.entity;

import com.koapti.lazychef.model.dto.UserDto;
import com.koapti.lazychef.model.entity.User;
import com.koapti.lazychef.model.types.RoleType;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntityMapper {
    public static User toUserEntity(final com.koapti.lazychef.api.model.User apiUser) {
        User user = new User();
        user.setLogin(apiUser.getLogin());
        user.setName(apiUser.getName());
        user.setSurname(apiUser.getSurname());
        user.setRole(RoleType.valueOf(apiUser.getRole().name()));
        user.setPassword(apiUser.getPassword());
        return user;
    }
}
