package com.thrishank1st.first.demo.review.implimentation;

import com.thrishank1st.first.demo.company.Company;
import com.thrishank1st.first.demo.company.CompanyService;
import com.thrishank1st.first.demo.review.Review;
import com.thrishank1st.first.demo.review.ReviewRepository;
import com.thrishank1st.first.demo.review.ReviewService;
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
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public Review addReview(Long companyId, Review review) {
        Company company = companyService.getCompById(companyId);
        if (company != null){
            review.setCompany(company);
            return reviewRepository.save(review);
        }
        return null;
    }

    @Override
    public Review getAreview(Long companyId, Long id) {
        return getAllReviews(companyId).stream()
                .filter(review -> review.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        for (Review r:reviews) {
           if( r.getId().equals(reviewId)){
               review.setId(reviewId);
               review.setCompany(companyService.getCompById(companyId));
               reviewRepository.save(review);
               return true;
        }}
        return false;

        }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        for (Review review : reviews) {
            if (review.getId().equals(reviewId)) {
                /* Company company = review.getCompany();
                company.getReviews().remove(review);
                review.setCompany(null);
                companyService.updateComp(companyId, company);*/
                reviewRepository.deleteById(reviewId);
                return true;
            }
        }
        return false;
    }

}
