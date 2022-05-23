package com.koapti.lazychef.model.mappers.entity;

import com.koapti.lazychef.model.dto.UserDto;
import com.koapti.lazychef.model.entity.User;

public class UserEntityMapper {
    public static User toUserEntity(final UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setRole(userDto.getRole());
        user.setPassword(user.getPassword());
        return user;
    }
}
