package com.example.demo.repository;


import com.example.demo.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CountryRepository extends MongoRepository<Country,String> {


    @Query("{'country':{$regex:/^?0.*/,$options:'i'}}")
     List<Country>findAll(String secretWord);

}
