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
@RequestMapping("/ownership")
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
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true,"Success",ownershipResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOwnerShip(@RequestBody OwnershipRE ownershipRE,@PathVariable(value = "id")String id){


       Optional<Ownership> ownershipResponse = ownershipService.updateOwnership(id,ownershipRE);



       if(ownershipResponse.isPresent()){
           return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", new OwnershipDTO(ownershipResponse.get())));
       }

       return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false,"Not Success",null));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwnership(@PathVariable(value = "id")String id){


        Optional<Ownership> ownership = ownershipService.getOwnershipById(id);

        if(ownership.isPresent()){
            ownershipService.deleteOwnershipById(id);

            return ResponseEntity.ok().body(new GenericResponseDTO<>(true,"Success",true));
        }

        return ResponseEntity.ok().body(new GenericResponseDTO<>(false,"Not Success",false));
    }


}
