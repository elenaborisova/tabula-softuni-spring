package com.example.tabulasoftunispring.services.impl;

import com.example.tabulasoftunispring.models.entities.RoleEntity;
import com.example.tabulasoftunispring.models.entities.UserEntity;
import com.example.tabulasoftunispring.repositories.UserRepository;
import com.example.tabulasoftunispring.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    public UserEntity getOrCreateUser(String email) {

        Objects.requireNonNull(email);

        return userRepository
                .findOneByEmail(email)
                .orElse(createUser(email));
    }

    @Override
    public UserEntity createUser(String email) {
        return createUser(email, null);
    }

    @Override
    public UserEntity createUser(String email, String password) {
        LOGGER.info("Creating a new user with email [GDPR].");

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);

        if (password != null) {
            userEntity.setPasswordHash(passwordEncoder.encode(password));
        }

        RoleEntity userRole = new RoleEntity();
        userRole.setRole("ROLE_USER");

        userEntity.setRoles(List.of(userRole));

        return userRepository.save(userEntity);
    }

    @Override
    public void createAndLoginUser(String email, String password) {
        UserEntity newUser = createUser(email, password);

        UserDetails userDetails = userDetailsService.loadUserByUsername(newUser.getEmail());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userDetails,
                password,
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean existsUser(String email) {
        Objects.requireNonNull(email);
        return userRepository.findOneByEmail(email).isPresent();
    }
}
