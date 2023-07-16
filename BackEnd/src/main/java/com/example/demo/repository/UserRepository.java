package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
    void deleteByName(String nombre);
}
