package com.example.shoppingmall.domain.product.controller.dto.response;

import com.example.shoppingmall.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Date;

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

    @Builder
    public ProductResponse(User seller, String category, String title, String description, Integer price, Date postDate, String imageURL) {
        this.seller = seller;
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.postDate = postDate;
        this.imageURL = imageURL;
    }
}
