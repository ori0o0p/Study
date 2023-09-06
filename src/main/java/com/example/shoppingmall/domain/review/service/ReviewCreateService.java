package com.example.shoppingmall.domain.review.service;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
import com.example.shoppingmall.domain.review.controller.dto.request.ReviewRequest;
import com.example.shoppingmall.domain.review.entity.Review;
import com.example.shoppingmall.domain.review.repository.ReviewRepository;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCreateService {
    private final ReviewRepository reviewRepository;
    private final UserFacade userFacade;
    private final ProductFacade productFacade;

    public void execute(ReviewRequest request) {
        User user = userFacade.getUser();
        Product product = productFacade.getProductById(request.getProductId());

        reviewRepository.save(Review.builder()
                .product(product)
                .rating(request.getRating())
                .contents(request.getContents())
                .writer(user)
                .imageURL(request.getImageURL())
                .build());
    }

}
