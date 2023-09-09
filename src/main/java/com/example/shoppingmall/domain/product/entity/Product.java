package com.example.shoppingmall.domain.product.entity;

import com.example.shoppingmall.domain.review.entity.Review;
import com.example.shoppingmall.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Document
public class Product {
    @Id
    private String id;

    @DBRef
    private User seller;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String category;

    private Integer price;

    private Integer stock = 0;

    @NotBlank
    private Date postedDate;

    private String imageURL = "";

    @DBRef
    private List<Review> review;

    @Builder
    public Product(User seller, String title, String description, String category, Integer price, Integer stock, Date postedDate, String imageURL) {
        this.seller = seller;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.postedDate = postedDate;
        this.imageURL = imageURL;
    }

    public void modify(String title, String description, String category, Integer price, Date modifiedDate, String imageURL) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.postedDate = modifiedDate;
        this.imageURL = imageURL;
    }

    public void modifyStock(Integer stock) {
        this.stock = stock;
    }

    public void purchase(Integer stock) {
        this.stock = stock;
    }

}
