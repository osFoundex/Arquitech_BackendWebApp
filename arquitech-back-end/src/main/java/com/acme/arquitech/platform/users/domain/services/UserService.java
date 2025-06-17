package com.acme.arquitech.platform.users.domain.services;
import com.acme.arquitech.platform.users.domain.model.aggregates.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    User update(Long id, User user);
    void delete(Long id);
}