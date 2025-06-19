package com.acme.arquitech.platform.users.interfaces.rest.resources;

import com.acme.arquitech.platform.users.domain.model.valueobjects.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserResource(
        @NotBlank @Size(max = 100) String name,
        @NotBlank @Email @Size(max = 255) String email,
        @NotBlank @Size(max = 255) String password,
        @NotNull Role role,
        @Size(max = 255) String profilePicture) {
}