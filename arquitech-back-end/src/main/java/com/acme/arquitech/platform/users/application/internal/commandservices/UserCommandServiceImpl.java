package com.acme.arquitech.platform.users.application.internal.commandservices;

import com.acme.arquitech.platform.users.domain.model.aggregates.User;
import com.acme.arquitech.platform.users.domain.exceptions.UserNotFoundException;
import com.acme.arquitech.platform.users.domain.services.UserService;
import com.acme.arquitech.platform.users.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        // Basic validation (can be extended with more checks)
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        }
        return userRepository.save(user);
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
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.update(user.getName(), user.getEmail(), user.getPassword(),
                            user.getRole(), user.getProfilePicture());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}