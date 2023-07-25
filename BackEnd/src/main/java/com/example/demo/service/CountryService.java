package com.example.demo.service;


import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
     CountryRepository countryRepository;

    public List<Country> listAllCountry(){
        return countryRepository.findAll();
    }

    public List<Country>listAllCountryBySecretWord(String secretWord){
        if(secretWord!=null){
            return countryRepository.findAll(secretWord);
        }
        return countryRepository.findAll();
    }
}
