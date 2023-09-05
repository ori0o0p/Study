package com.example.shoppingmall.domain.product.entity;

import com.example.shoppingmall.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@NoArgsConstructor
@Document(collation = "product")
public class Product {
    @Id
    private String id;

    @DBRef(db = "user")
    private User seller;

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String category;

    private Integer price;
    private Integer stock;

    @NotBlank
    private Date postdate;

    private String imageURL = "";

    @Builder
    public Product(User seller, String title, String description, String category, Integer price, Integer stock, Date postdate, String imageURL) {
        this.seller = seller;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.postdate = postdate;
        this.imageURL = imageURL;
    }

    public void Modify(String title, String description, String category, Integer price, String imageURL) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imageURL = imageURL;
    }

}
