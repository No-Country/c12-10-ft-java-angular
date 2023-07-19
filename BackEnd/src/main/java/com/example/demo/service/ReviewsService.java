package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Reviews;
import com.example.demo.repository.ReviewsRepository;

@Service
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    // Get all reviews
    public List<Reviews> listReviews() {
        return reviewsRepository.findAll();
    }

    // Get reviews by userId
    public List<Reviews> getReviewsByUserId(String userId) {
        System.out.println("Reviews por userId: " + userId);
        return reviewsRepository.findByuserId(userId);
    }

    // Get reviews by ownershipId
    public List<Reviews> getReviewsByOwnershipId(String ownershipId) {
        System.out.println("Reviews por ownershipId: " + ownershipId);
        return reviewsRepository.findByownershipId(ownershipId);
    }

    // Post reviews
    public Reviews saveReviews(Reviews reviews) {
        System.out.println("Reviews Agregado: " + reviews.toString());
        return reviewsRepository.save(reviews);
    }

    // Update reviews
    public Reviews updaReviews(String id, Reviews reviews) {
        Reviews reviewsToUpdate = reviewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reviews not found"));
        if (reviews.getUserId() != null)
            reviewsToUpdate.setUserId(reviews.getUserId());
        if (reviews.getOwnershipId() != null)
            reviewsToUpdate.setOwnershipId(reviews.getOwnershipId());
        if (reviews.getComment() != null)
            reviewsToUpdate.setComment(reviews.getComment());
        if (reviews.getPostDate() != null)
            reviewsToUpdate.setPostDate(reviews.getPostDate());
        if (reviews.getScore() != null)
            reviewsToUpdate.setScore(reviews.getScore());
        return reviewsRepository.save(reviewsToUpdate);
    }

    // Delete reviews
    public boolean deleteReviews(String id) {
        reviewsRepository.deleteById(id);
        return true;
    }
}
