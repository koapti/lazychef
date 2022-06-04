package com.koapti.lazychef.http.handler.users;

import com.koapti.lazychef.api.model.User;
import com.koapti.lazychef.http.exceptions.UserAlreadyExistsException;
import com.koapti.lazychef.http.service.UserService;
import com.koapti.lazychef.model.mappers.entity.UserEntityMapper;
import com.koapti.lazychef.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(staticName = "of")
public class CreateUserHandler {

    private final UserRepository userRepository;
    private final UserService userService;

    public String handle(final User user) throws UserAlreadyExistsException {
        if (userService.isUserAlreadyExists(user.getLogin())) {
            throw new UserAlreadyExistsException("User with login \"" + user.getName() + "\" already exists.");
        }
        com.koapti.lazychef.model.entity.User save = userRepository.save(UserEntityMapper.toUserEntity(user));
        return save.getId().toString();
    }
}
