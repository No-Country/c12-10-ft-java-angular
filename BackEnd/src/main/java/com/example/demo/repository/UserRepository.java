package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    // busqueda por userId
    UserEntity findByUserId(String userId);

    UserEntity findUserByUsername(String name);

    void deleteByName(String nombre);

    // login email and password
    UserEntity findByEmailAndPassword(String email, String password);

    UserEntity findByEmail(String email);
}
