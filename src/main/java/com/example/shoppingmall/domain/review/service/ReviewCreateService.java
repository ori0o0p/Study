package com.example.shoppingmall.domain.review.service;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
import com.example.shoppingmall.domain.review.controller.dto.request.ReviewRequest;
import com.example.shoppingmall.domain.review.entity.Review;
import com.example.shoppingmall.domain.review.repository.ReviewRepository;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.service.facade.UserFacade;
import com.example.shoppingmall.global.facade.DateFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ReviewCreateService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final UserFacade userFacade;
    private final ProductFacade productFacade;
    private final DateFacade dateFacade;

    public void execute(ReviewRequest request) {
        User user = userFacade.getUser();
        Product product = productFacade.getProductById(request.getProductId());
        Date now = dateFacade.getNowDate();
        Review review = Review.builder()
                .product(product)
                .rating(request.getRating())
                .content(request.getContent())
                .writer(user)
                .createdDate(now)
                .imageURL(request.getImageURL())
                .build();

        reviewRepository.save(review);

        product.getReview().add(review);
        productRepository.save(product);
    }

}
