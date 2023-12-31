package com.example.shoppingmall.domain.review.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ReviewRequest {
    private String productId;

    private Integer rating;

    private String content;

    private String imageURL;

}
