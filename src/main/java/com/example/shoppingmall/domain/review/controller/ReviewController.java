package com.example.shoppingmall.domain.review.controller;

import com.example.shoppingmall.domain.review.controller.dto.request.ReviewRequest;
import com.example.shoppingmall.domain.review.controller.dto.request.ReviewUpdateRequest;
import com.example.shoppingmall.domain.review.service.ReviewCreateService;
import com.example.shoppingmall.domain.review.service.ReviewDeleteService;
import com.example.shoppingmall.domain.review.service.ReviewUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewCreateService reviewCreateService;
    private final ReviewUpdateService reviewUpdateService;
    private final ReviewDeleteService reviewDeleteService;

    @PostMapping
    public void create(@RequestBody ReviewRequest request) {
        reviewCreateService.execute(request);
    }

    @PutMapping
    public void update(@RequestBody ReviewUpdateRequest request) {
        reviewUpdateService.execute(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        reviewDeleteService.deleteByReviewId(id);
    }

}
