package com.example.demo.repository;

import com.example.demo.entity.Ownership;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnershipRepository extends MongoRepository<Ownership, String> {

    Ownership findOwnershipById(String ownershipId);

    List<Ownership> findAllOwnershipByCountry(String name);

    List<Ownership> findAllOwnershipByCity(String name);
}
