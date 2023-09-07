package com.example.shoppingmall.domain.review.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
public class ReviewResponse {
    private Integer rating;

    private String content;

    private Date createdDate;

    private String imageURL;

    public ReviewResponse(Integer rating, String content, Date createdDate, String imageURL) {
        this.rating = rating;
        this.content = content;
        this.createdDate = createdDate;
        this.imageURL= imageURL;

    }
}
