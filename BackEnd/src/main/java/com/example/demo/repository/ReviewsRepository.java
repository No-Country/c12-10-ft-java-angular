package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Reviews;

public interface ReviewsRepository extends MongoRepository<Reviews, String> {
    List<Reviews> findByuserId(String userId);

    List<Reviews> findByownershipId(String ownershipId);
}
