package com.example.shoppingmall.domain.review.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class ReviewRequest {
    private Integer rating;

    private String productId;

    private String content;

    private String imageURL;

}
