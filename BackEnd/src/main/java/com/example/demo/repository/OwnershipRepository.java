package com.example.demo.repository;

import com.example.demo.entity.Ownership;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnershipRepository extends MongoRepository<Ownership,String> {
}
