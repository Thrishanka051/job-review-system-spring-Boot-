package com.thrishank1st.first.demo.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comps/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<Review> addReview (@PathVariable Long companyId,@RequestBody Review review){
        Review adedReview = reviewService.addReview(companyId,review);
        if(adedReview != null)
            return new ResponseEntity<>(adedReview,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReview (@PathVariable Long companyId, @PathVariable Long id){
        Review review = reviewService.getAreview(companyId,id);
        if(review != null){
            return new ResponseEntity<>(review,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("reviews/{reviewId}")
    public ResponseEntity<String> updateReview (@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review){
        boolean isUpdated = reviewService.updateReview(companyId,reviewId,review);
        if(isUpdated)
            return new ResponseEntity<>("updated success ",HttpStatus.OK);
        return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("reviews/{reviewId}")
    public ResponseEntity<String> deleteReview (@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReview(companyId,reviewId);
        if(isDeleted){
            return new ResponseEntity<>("successfully deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("not deleted",HttpStatus.NOT_FOUND);
    }
}
