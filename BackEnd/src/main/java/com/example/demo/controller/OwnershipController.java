package com.example.demo.controller;

import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.dto.OwnershipDTO;
import com.example.demo.entity.Ownership;
import com.example.demo.requestEntity.OwnershipRE;
import com.example.demo.service.OwnershipService;
import com.example.demo.service.RoleVerificationService;
import com.example.demo.util.AppTypes;
import com.mongodb.lang.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ownership")
public class OwnershipController {

    @Autowired
    private OwnershipService ownershipService;

    @Autowired
    private RoleVerificationService roleVerificationService;

    @PostMapping("/create")
    public ResponseEntity<?> createOwnerShip(@RequestBody OwnershipRE ownershipRE) {

        Optional<OwnershipDTO> ownershipDTOResponse = ownershipService.saveOwnership(ownershipRE);
        if (ownershipDTOResponse.isPresent()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", ownershipDTOResponse));
        }

        return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false, "No Success", null));
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAllOwnership() {

        List<Ownership> ownershipResponse = ownershipService.listOwnership();
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", ownershipResponse));
    }

    @GetMapping("/listAllOwnershipByCountry/{name}")
    public ResponseEntity<?> listAllOwnershipByCountry(@PathVariable(value = "name") String name) {
        List<Ownership> listAllCountry = ownershipService.listAllOwnershipByCountry(name.toLowerCase());
        if (!listAllCountry.isEmpty()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", listAllCountry));
        }
        return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false, "Empty", null));
    }

    @GetMapping("/listAllOwnershipByCity/{name}")
    public ResponseEntity<?> listAllOwnershipByCity(@PathVariable(value = "name") String name) {
        List<Ownership> listAllCity = ownershipService.listAllOwnershipByCity(name.toLowerCase());
        if (!listAllCity.isEmpty()) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", listAllCity));
        }
        return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false, "Empty", null));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOwnerShip(@RequestBody OwnershipRE ownershipRE,
            @PathVariable(value = "id") String id) {

        Optional<Ownership> ownershipResponse = ownershipService.getOwnershipById(id);
        if (ownershipResponse.isPresent()) {
            Optional<Ownership> ownershipResponse1 = ownershipService.updateOwnership(ownershipRE);
            return ResponseEntity.ok()
                    .body(new GenericResponseDTO<>(true, "Success", new OwnershipDTO(ownershipResponse1.get())));
        }

        return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false, "Not Success", null));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwnership(@PathVariable(value = "id") String id) {

        Boolean ownerDelete = ownershipService.deleteOwnershipById(id);

        if (ownerDelete) {
            return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", true));
        }

        return ResponseEntity.badRequest().body(new GenericResponseDTO<>(false, "Not Found", false));

    }

}
