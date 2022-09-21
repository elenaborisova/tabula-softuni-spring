package com.example.tabulasoftunispring.services.impl;

import com.example.tabulasoftunispring.models.entities.RoleEntity;
import com.example.tabulasoftunispring.models.entities.UserEntity;
import com.example.tabulasoftunispring.repositories.UserRepository;
import com.example.tabulasoftunispring.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Override
    public UserEntity getOrCreateUser(String email) {

        Objects.requireNonNull(email);

        return userRepository
                .findOneByEmail(email)
                .orElse(createUser(email));
    }

    @Override
    public UserEntity createUser(String email) {

        LOGGER.info("Creating a new user with email [GDPR].");

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);

        RoleEntity userRole = new RoleEntity();
        userRole.setRole("ROLE_USER");

        userEntity.setRoles(List.of(userRole));

        return userRepository.save(userEntity);
    }
}
