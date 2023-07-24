package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.util.AppTypes;

@Service
public class RoleVerificationService {


    public Boolean appHeaderValidator(String appHeader,AppTypes expectedType){
        return expectedType.toString().equals(appHeader.toUpperCase());
    }




}
