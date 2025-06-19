package com.acme.arquitech.platform.users.domain.model.aggregates;

import com.acme.arquitech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.acme.arquitech.platform.users.domain.model.valueobjects.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends AuditableAbstractAggregateRoot<User> {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 255)
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Size(max = 255)
    private String profilePicture;


    public User(String name, String email, String password, Role role, String profilePicture) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profilePicture = profilePicture;
    }

    public User update(String name, String email, String password, Role role, String profilePicture) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.profilePicture = profilePicture;
        return this;
    }
}