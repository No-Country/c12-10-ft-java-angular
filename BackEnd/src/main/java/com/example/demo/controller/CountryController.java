package com.example.demo.controller;


import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
     CountryService countryService;

    @GetMapping("/listAll")
    public ResponseEntity<?> listAllCountries(){
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true,"Success",  countryService.listAllCountry())) ;
    }

    @GetMapping("/listAllByWord/{secretWord}")
    public ResponseEntity<?> listAllCountries(@PathVariable(value = "secretWord")String secretWord){
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true,"Success",  countryService.listAllCountryBySecretWord(secretWord.toLowerCase()))) ;
    }







}

