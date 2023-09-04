package com.example.shoppingmall.domain.product.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class ProductResponse {
    private String sellerEmail;

    private String title;
    private String description;
    private String category;
    private Integer price;
    private String imageURL;

}
