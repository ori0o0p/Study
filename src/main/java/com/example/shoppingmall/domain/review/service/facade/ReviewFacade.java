package com.example.shoppingmall.domain.review.service.facade;

import com.example.shoppingmall.domain.review.controller.dto.response.ReviewResponse;
import com.example.shoppingmall.domain.review.entity.Review;
import com.example.shoppingmall.domain.review.exception.ReviewNotFoundException;
import com.example.shoppingmall.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewFacade {
    private final ReviewRepository reviewRepository;

    public Review getReviewById(String id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> ReviewNotFoundException.EXCEPTION);
    }

    public List<Review> getReviewByProductId(String id) {
        return reviewRepository.findByProductId(id);
    }
}
