package com.koapti.lazychef.model.dto;

import java.io.Serializable;

import com.koapti.lazychef.model.types.RoleType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto implements Serializable {
    private final Integer id;
    private final String login;
    private final String name;
    private final String password;
    private final RoleType role;
    private final String surname;
}
