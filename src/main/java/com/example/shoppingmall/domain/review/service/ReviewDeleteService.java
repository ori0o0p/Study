package com.example.shoppingmall.domain.review.service;

import com.example.shoppingmall.domain.review.entity.Review;
import com.example.shoppingmall.domain.review.repository.ReviewRepository;
import com.example.shoppingmall.domain.review.service.facade.ReviewFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewDeleteService {
    private final ReviewRepository reviewRepository;
    private final ReviewFacade reviewFacade;

    public void deleteByReviewId(String id) {
        Review review = reviewFacade.getReviewById(id);
        reviewRepository.deleteById(review.getId());
    }

    public void deleteByProductId(String id) {
        List<Review> reviewList = reviewFacade.getReviewByProductId(id);
        reviewRepository.deleteAll(reviewList);
    }


}
