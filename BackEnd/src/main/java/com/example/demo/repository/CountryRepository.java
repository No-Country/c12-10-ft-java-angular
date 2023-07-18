package com.example.demo.repository;


import com.example.demo.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends MongoRepository<Country,String> {

}
