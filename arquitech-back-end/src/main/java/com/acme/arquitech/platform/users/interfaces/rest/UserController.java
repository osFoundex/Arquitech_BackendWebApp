package com.acme.arquitech.platform.users.interfaces.rest;

import com.acme.arquitech.platform.shared.interfaces.rest.resources.MessageResource;
import com.acme.arquitech.platform.users.domain.model.aggregates.User;
import com.acme.arquitech.platform.users.domain.services.UserService;
import com.acme.arquitech.platform.users.interfaces.rest.resources.CreateUserResource;
import com.acme.arquitech.platform.users.interfaces.rest.resources.UpdateUserResource;
import com.acme.arquitech.platform.users.interfaces.rest.resources.UserResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "User Management Endpoints")
public class UserController {

    private final UserService userService;

    public UserController(@Qualifier("userCommandServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@Valid @RequestBody CreateUserResource resource) {
        User user = new User(
                resource.name(),
                resource.email(),
                resource.password(),
                resource.role(),
                resource.profilePicture()
        );
        User savedUser = userService.create(user);
        UserResource userResource = new UserResource(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getPassword(),
                savedUser.getRole(),
                savedUser.getProfilePicture()
        );
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> new UserResource(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getRole(),
                        user.getProfilePicture()
                ))
                .map(userResource -> new ResponseEntity<>(userResource, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {
        List<UserResource> users = userService.findAll().stream()
                .map(user -> new UserResource(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getRole(),
                        user.getProfilePicture()
                ))
                .toList();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResource> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserResource resource) {
        User user = new User(
                resource.name(),
                resource.email(),
                resource.password(),
                resource.role(),
                resource.profilePicture()
        );
        User updatedUser = userService.update(id, user);
        UserResource userResource = new UserResource(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getPassword(),
                updatedUser.getRole(),
                updatedUser.getProfilePicture()
        );
        return new ResponseEntity<>(userResource, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResource> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(new MessageResource("User deleted successfully"), HttpStatus.OK);
    }
}