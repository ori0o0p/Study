package com.example.shoppingmall.domain.product.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductModifyRequest {
    private String title;

    private String description;

    private String category;

    private Integer price;

    private String imageURL;

}
