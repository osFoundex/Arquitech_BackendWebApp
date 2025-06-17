package com.acme.arquitech.platform.users.application.internal.queryservices;

import com.acme.arquitech.platform.users.domain.model.aggregates.User;
import com.acme.arquitech.platform.users.domain.services.UserService;
import com.acme.arquitech.platform.users.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        throw new UnsupportedOperationException("Use command service for create operations");
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, User user) {
        throw new UnsupportedOperationException("Use command service for update operations");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Use command service for delete operations");
    }
}