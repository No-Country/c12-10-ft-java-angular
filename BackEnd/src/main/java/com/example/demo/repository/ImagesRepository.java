package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Images;

public interface ImagesRepository extends MongoRepository<Images, String> {

    Images findByOwnershipId(String ownershipId);
}
