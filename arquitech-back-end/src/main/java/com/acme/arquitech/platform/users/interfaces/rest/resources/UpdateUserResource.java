package com.acme.arquitech.platform.users.interfaces.rest.resources;

import com.acme.arquitech.platform.users.domain.model.valueobjects.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateUserResource(
        @Size(max = 100) String name,
        @Email @Size(max = 255) String email,
        @Size(max = 255) String password,
        Role role,
        @Size(max = 255) String profilePicture) {
}