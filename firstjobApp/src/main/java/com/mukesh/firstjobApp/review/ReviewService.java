package com.mukesh.firstjobApp.review;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    List <Review> getAllReviews(Long companyId);
    boolean createReview(Long companyID, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, long reviewId, Review review);
}
