package com.acme.arquitech.platform.users.infrastructure.persistence.jpa.repositories;

import com.acme.arquitech.platform.users.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

}