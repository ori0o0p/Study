package com.example.shoppingmall.domain.review.service;

import com.example.shoppingmall.domain.review.controller.dto.request.ReviewUpdateRequest;
import com.example.shoppingmall.domain.review.entity.Review;
import com.example.shoppingmall.domain.review.repository.ReviewRepository;
import com.example.shoppingmall.domain.review.service.facade.ReviewFacade;
import com.example.shoppingmall.global.facade.DateFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReviewUpdateService {
    private final ReviewRepository reviewRepository;
    private final ReviewFacade reviewFacade;
    private final DateFacade dateFacade;

    public void execute(ReviewUpdateRequest request) {
        Review review = reviewFacade.getReviewById(request.getId());
        Date now = dateFacade.getNowDate();
        review.update(request.getRating(),
                request.getContent(),
                now,
                request.getImageURL());
     reviewRepository.save(review);
    }

}
