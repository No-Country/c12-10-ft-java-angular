package com.example.demo.controller;


import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.dto.OwnershipDTO;
import com.example.demo.entity.Ownership;
import com.example.demo.requestEntity.OwnershipRE;
import com.example.demo.service.OwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("ownership")
public class OwnershipController {

    @Autowired
    private OwnershipService ownershipService;


    @PostMapping("/")
    public ResponseEntity<?> createOwnerShip(@RequestBody OwnershipRE ownershipRE){

        Optional<OwnershipDTO> ownershipDTOResponse = ownershipService.saveOwnership(ownershipRE);
        if(ownershipDTOResponse.isPresent()){
            return ResponseEntity.ok().body(new GenericResponseDTO<>(true,"Success",ownershipDTOResponse));
        }

        return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false,"No Success",null));
    }

    @GetMapping("/")
    public ResponseEntity<?> listAllOwnership(){

        List<Ownership> ownershipResponse =  ownershipService.listOwnership();
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true,"Sucess",ownershipResponse));
    }


}
