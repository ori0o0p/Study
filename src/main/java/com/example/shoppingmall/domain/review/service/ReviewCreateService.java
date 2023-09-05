package com.example.shoppingmall.domain.review.service;

import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.review.repository.ReviewRepository;
import com.example.shoppingmall.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCreateService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public void execute() {

    }



}
