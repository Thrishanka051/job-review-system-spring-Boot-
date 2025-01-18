package com.thrishank1st.first.demo.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long companyId);

    Review addReview (Long companyId, Review review);

    Review getAreview (Long companyId, Long id);

    boolean updateReview (Long companyId, Long reviewId, Review review);

    boolean deleteReview (Long companyId, Long reviewId);
}
