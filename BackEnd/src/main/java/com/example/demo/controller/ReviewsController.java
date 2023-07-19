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
import com.example.demo.entity.Reviews;
import com.example.demo.service.ReviewsService;

@RestController
public class ReviewsController {
    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    // Get all reviews
    @GetMapping("/reviews")
    public ResponseEntity<?> listReviews() {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", reviewsService.listReviews()));
    }

    // Get reviews by userId
    @GetMapping("/reviews/user/{userId}")
    public ResponseEntity<?> getReviewsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", reviewsService.getReviewsByUserId(userId)));
    }

    // Get reviews by ownershipId
    @GetMapping("/reviews/ownership/{ownershipId}")
    public ResponseEntity<?> getReviewsByOwnershipId(@PathVariable String ownershipId) {
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", reviewsService.getReviewsByOwnershipId(ownershipId)));
    }

    // Post reviews
    @PostMapping("/reviews")
    public ResponseEntity<?> saveReviews(@RequestBody Reviews reviews) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", reviewsService.saveReviews(reviews)));
    }

    // Update reviews
    @PutMapping("/reviews/{id}")
    public ResponseEntity<?> updaReviews(@PathVariable String id, @RequestBody Reviews reviews) {
        return ResponseEntity.ok()
                .body(new GenericResponseDTO<>(true, "Success", reviewsService.updaReviews(id, reviews)));
    }

    // Delete reviews
    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<?> deleteReviews(@PathVariable String id) {
        return ResponseEntity.ok().body(new GenericResponseDTO<>(true, "Success", reviewsService.deleteReviews(id)));
    }
}
