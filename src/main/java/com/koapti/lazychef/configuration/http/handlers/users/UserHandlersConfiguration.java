package com.koapti.lazychef.configuration.http.handlers.users;

import com.koapti.lazychef.configuration.http.services.user.UserServiceConfiguration;
import com.koapti.lazychef.http.handler.users.CreateUserHandler;
import com.koapti.lazychef.http.handler.users.DeleteUserHandler;
import com.koapti.lazychef.http.handler.users.GetUserDetailsHandler;
import com.koapti.lazychef.http.handler.users.GetUsersHandler;
import com.koapti.lazychef.http.service.UserService;
import com.koapti.lazychef.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(UserServiceConfiguration.class)
public class UserHandlersConfiguration {

    @Bean
    public CreateUserHandler createUserHandler(final UserRepository userRepository, final UserService userService) {
        return CreateUserHandler.of(userRepository, userService);
    }

    @Bean
    public GetUserDetailsHandler getUserDetailsHandler(final UserRepository userRepository) {
        return GetUserDetailsHandler.of(userRepository);
    }

    @Bean
    public GetUsersHandler getUsersHandler(final UserRepository userRepository) {
        return GetUsersHandler.of(userRepository);
    }

    @Bean
    public DeleteUserHandler deleteUserHandler(final UserRepository userRepository) {
        return DeleteUserHandler.of(userRepository);
    }

}
