package com.mukesh.firstjobApp.review;

import java.util.List;

public interface ReviewService {
    List <Review> getAllReviews(Long companyId);
    boolean createReview(Long companyID, Review review);
}
