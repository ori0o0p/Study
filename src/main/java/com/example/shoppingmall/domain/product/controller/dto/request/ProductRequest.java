package com.example.shoppingmall.domain.product.controller.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ProductRequest {

    private String title;
    private String description;
    private String category;
    private Integer price;
    private Integer stock;
}
