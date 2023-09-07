package com.example.shoppingmall.domain.review.controller;

import com.example.shoppingmall.domain.review.controller.dto.request.ReviewRequest;
import com.example.shoppingmall.domain.review.service.ReviewCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewCreateService reviewCreateService;

    @PostMapping
    public void create(@RequestBody ReviewRequest request) {
        reviewCreateService.execute(request);
    }

}
