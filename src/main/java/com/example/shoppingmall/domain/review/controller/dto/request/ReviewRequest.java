package com.example.shoppingmall.domain.review.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest {
    private Integer rating;

    private String productId;

    private String contents;

    private String imageURL;

}
