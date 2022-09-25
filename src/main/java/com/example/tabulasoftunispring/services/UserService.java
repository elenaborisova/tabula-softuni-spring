package com.example.tabulasoftunispring.services;

import com.example.tabulasoftunispring.models.entities.UserEntity;

public interface UserService {
    UserEntity getOrCreateUser(String email);
    UserEntity createUser(String email);
    UserEntity createUser(String email, String password);
    void createAndLoginUser(String email, String password);
    boolean existsUser(String email);
}
