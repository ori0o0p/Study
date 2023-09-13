package com.example.shoppingmall.domain.product.controller.dto.response;

import com.example.shoppingmall.domain.review.controller.dto.response.ReviewResponse;
import com.example.shoppingmall.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
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
    public ProductResponse(User seller, String title, String description, String category, Integer price, List<ReviewResponse> review, Date postDate, String imageURL) {
        this.seller = seller;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.review = review;
        this.postDate = postDate;
        this.imageURL = imageURL;
    }

    public ProductResponse(User seller, String title, String description, String category, Integer price, Date postedDate, String imageURL) {
        this.seller = seller;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.postDate = postedDate;
        this.imageURL = imageURL;
    }

    public ProductResponse(String title, String description, String category, Integer price, Date postedDate, String imageURL) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.postDate = postedDate;
        this.imageURL = imageURL;
    }
}
