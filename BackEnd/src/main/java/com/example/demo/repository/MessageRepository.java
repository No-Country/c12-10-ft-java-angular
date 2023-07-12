package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
}
