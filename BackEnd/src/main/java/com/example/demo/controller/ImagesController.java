package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GenericResponseDTO;
import com.example.demo.entity.Images;
import com.example.demo.service.ImagesService;

@RestController
public class ImagesController {
    private final ImagesService imagesService;

    @Autowired
    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    // Get all imagess
    @GetMapping("/images")
    public ResponseEntity<?> listImages() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", imagesService.listImages()));
    }

    // Get images by id
    @GetMapping("/images/{id}")
    public ResponseEntity<?> getImagesById(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", imagesService.getImagesById(id)));
    }

    // Get images by userId
    @GetMapping("/images/user/{userId}")
    public ResponseEntity<?> getImagesByUserId(@PathVariable String userId) {
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", imagesService.getImagesByUserId(userId)));
    }

    // Post images
    @PostMapping("/images")
    public ResponseEntity<?> saveImages(@RequestBody Images images) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", imagesService.saveImages(images)));
    }

    // Update images
    @PutMapping("/images/{id}")
    public ResponseEntity<?> updateImages(@PathVariable String id, @RequestBody Images images) {
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", imagesService.updateImages(id, images)));
    }

    // Delete images
    @DeleteMapping("/images/{id}")
    public ResponseEntity<?> deleteImages(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", imagesService.deleteImages(id)));
    }

}
