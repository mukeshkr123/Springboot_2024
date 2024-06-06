package com.mukesh.firstjobApp.review.impl;

import com.mukesh.firstjobApp.company.Company;
import com.mukesh.firstjobApp.company.CompanyService;
import com.mukesh.firstjobApp.review.Review;
import com.mukesh.firstjobApp.review.ReviewRepository;
import com.mukesh.firstjobApp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean createReview(Long companyID, Review review) {
        Company company = companyService.getCompanyById(companyID);
        if(company != null){
            review.setCompany(company);
            reviewRepository.save(review);
            return  true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
       List<Review> reviews = reviewRepository.findByCompanyId(companyId);
       return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, long reviewId, Review updatedReview) {
        if(companyService.getCompanyById(companyId) != null){
          updatedReview.setCompany(companyService.getCompanyById(companyId));
          updatedReview.setId(reviewId);
          reviewRepository.save(updatedReview);
          return true;
        }
        return false;
    }
}
