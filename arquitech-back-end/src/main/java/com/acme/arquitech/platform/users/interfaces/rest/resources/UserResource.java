package com.acme.arquitech.platform.users.interfaces.rest.resources;

import com.acme.arquitech.platform.users.domain.model.valueobjects.Role;

public record UserResource(
        Long id,
        String name,
        String email,
        String password,
        Role role,
        String profilePicture) {
}