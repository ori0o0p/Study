package com.example.shoppingmall.domain.review.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponse {
    private Integer rating;

    private String content;

    private Date createdDate;

    private String imageURL;


}
