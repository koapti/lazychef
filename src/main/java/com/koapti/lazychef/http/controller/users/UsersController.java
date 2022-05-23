package com.koapti.lazychef.http.controller.users;

import javax.validation.Valid;

import com.koapti.lazychef.api.UsersApiDelegate;
import com.koapti.lazychef.api.model.User;
import com.koapti.lazychef.api.model.UsersList;
import com.koapti.lazychef.http.HttpConstants;
import com.koapti.lazychef.http.handler.users.CreateUserHandler;
import com.koapti.lazychef.http.handler.users.DeleteUserHandler;
import com.koapti.lazychef.http.handler.users.GetUserDetailsHandler;
import com.koapti.lazychef.http.handler.users.GetUsersHandler;
import com.koapti.lazychef.model.mappers.dto.UserDtoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController(HttpConstants.USERS_HTTP_ENDPOINT)
@AllArgsConstructor(staticName = "of")
public class UsersController implements UsersApiDelegate {

    private CreateUserHandler createUserHandler;
    private GetUserDetailsHandler getUserDetailshandler;
    private GetUsersHandler getUsersHandler;
    private DeleteUserHandler deleteUserHandler;

    @Override
    @ApiOperation(value = "", nickname = "createUser", notes = "Create user")
    @ApiResponses({@ApiResponse(code = 201, message = "User created successfully")})
    @PostMapping
    public ResponseEntity<Void> createUser(@ApiParam(value = "User details to create", required = true) @RequestBody @Valid User user) {
        createUserHandler.handle(UserDtoMapper.toDomainUser(user));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @ApiOperation(value = "", nickname = "getUserDetails", notes = "Get user details")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "User details", response = User.class)})
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserDetails(@ApiParam(value = "The ID of the specific user for which you want details.", required = true)
                                               @PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    @ApiOperation(value = "", nickname = "getUsersList", notes = "Get users list")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Users list", response = UsersList.class)})
    @GetMapping
    public ResponseEntity<UsersList> getUsersList() {
        return new ResponseEntity<>(getUsersHandler.handle(), HttpStatus.OK);
    }

    @Override
    @ApiOperation(value = "", nickname = "deleteUser", notes = "Delete user")
    @ApiResponses({@ApiResponse(code = 200, message = "User deleted successfully")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@ApiParam(value = "The ID of the specific user witch you want delete.", required = true)
                                           @PathVariable("id") String id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
