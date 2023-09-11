package com.example.shoppingmall.domain.product.controller.dto.response;

import com.example.shoppingmall.domain.review.controller.dto.response.ReviewResponse;
import com.example.shoppingmall.domain.review.entity.Review;
import com.example.shoppingmall.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class ProductResponse {
    private User seller;

    private String title;

    private String description;

    private String category;

    private Integer price;

    private String imageURL;

    private Date postDate;

    private List<ReviewResponse> review;

    @Builder
    public ProductResponse(User seller, String category, String title, String description, Integer price, List<ReviewResponse> review, Date postDate, String imageURL) {
        this.seller = seller;
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.review = review;
        this.postDate = postDate;
        this.imageURL = imageURL;
    }

    public ProductResponse(User seller, String category, String title, String description, Integer price, Date postedDate, String imageURL) {
        this.seller = seller;
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.postDate = postedDate;
        this.imageURL = imageURL;
    }
}
