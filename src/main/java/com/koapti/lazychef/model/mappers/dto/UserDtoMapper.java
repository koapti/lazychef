package com.koapti.lazychef.model.mappers.dto;

import com.koapti.lazychef.api.model.User;
import com.koapti.lazychef.model.dto.UserDto;
import com.koapti.lazychef.model.types.RoleType;

public class UserDtoMapper {
    public static UserDto toDomainUser(final User user) {
        return UserDto.builder()
                .login(user.getLogin())
                .name(user.getName())
                .password(user.getPassword())
                .role(RoleType.valueOf(user.getRole().name()))
                .surname(user.getSurname())
                .build();
    }

}
