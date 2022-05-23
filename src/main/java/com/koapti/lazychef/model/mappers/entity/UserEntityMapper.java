package com.koapti.lazychef.model.mappers.entity;

import com.koapti.lazychef.model.dto.UserDto;
import com.koapti.lazychef.model.entity.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntityMapper {
    public static User toUserEntity(final UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setRole(userDto.getRole());
        user.setPassword(user.getPassword());
        return user;
    }
}
