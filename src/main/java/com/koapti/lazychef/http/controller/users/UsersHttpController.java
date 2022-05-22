package com.koapti.lazychef.http.controller.users;

import com.koapti.lazychef.http.HttpConstants;
import com.koapti.lazychef.http.handler.users.CreateUserHandler;
import com.koapti.lazychef.http.handler.users.DeleteUserHandler;
import com.koapti.lazychef.http.handler.users.GetUserDetailshandler;
import com.koapti.lazychef.http.handler.users.GetUsersHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = HttpConstants.USERS_HTTP_ENDPOINT)
public class UsersHttpController {

    private CreateUserHandler createUserHandler;
    private GetUserDetailshandler getUserDetailshandler;
    private GetUsersHandler getUsersHandler;
    private DeleteUserHandler deleteUserHandler;

    @PostMapping
    public String createUser(@RequestBody final String body) { // TODO: do omowienia jakie to ma byc body
        return createUserHandler.handle();
    }
//
//    @GetMapping(value = "/{id}")
//    public String getUserDetails(@PathVariable final String id) { // TODO: typ ma byc UserDTO, zrobic mapper
//        return getUserDetailshandler.handle(id);
//    }
//
//    @GetMapping
//    public String getUsers() {  // TODO: analogicznie jak wyzej, tylko tu ma byc lista
//        return getUsersHandler.handle();
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public String deleteUser(@PathVariable final String id) {
//        return deleteUserHandler.handle(id);
//    }
}
