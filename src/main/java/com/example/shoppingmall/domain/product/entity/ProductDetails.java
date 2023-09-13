package com.example.shoppingmall.domain.product.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductDetails {
        private String title;
        private String description;
        private String category;
        private Integer price;
        private String imageURL;

        @Builder
        public ProductDetails(String title, String description, String category, Integer price, String imageURL) {
                this.title = title;
                this.description = description;
                this.category = category;
                this.price = price;
                this.imageURL = imageURL;
        }
}