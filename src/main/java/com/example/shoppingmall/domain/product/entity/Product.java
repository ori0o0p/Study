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
import java.util.ArrayList;
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

    private Date postedDate;

    private String imageURL = "";

    @DBRef
    private List<Review> review = new ArrayList<>();

    @Builder
    public Product(User seller, ProductDetails details, Integer stock, Date postedDate) {
        this.seller = seller;
        this.title = details.getTitle();
        this.description = details.getDescription();
        this.category = details.getCategory();
        this.imageURL = details.getImageURL();
        this.price = details.getPrice();
        this.stock = stock;
        this.postedDate = postedDate;
    }

    public void updateProductDetails(String title, String description, String category, Integer price, Date modifiedDate, String imageURL) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.postedDate = modifiedDate;
        this.imageURL = imageURL;
    }

    public void updateStock(Integer stock) {
        this.stock = stock;
    }

    public void purchaseProduct(Integer stock) {
        this.stock = stock;
    }
}
