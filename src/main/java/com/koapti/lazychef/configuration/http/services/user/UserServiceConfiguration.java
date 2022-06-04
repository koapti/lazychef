package com.koapti.lazychef.configuration.http.services.user;

import com.koapti.lazychef.http.service.UserService;
import com.koapti.lazychef.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfiguration {

    @Bean
    public UserService userService(final UserRepository userRepository) {
        return UserService.of(userRepository);
    }
}
