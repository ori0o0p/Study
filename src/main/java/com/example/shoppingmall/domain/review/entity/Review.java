package com.example.shoppingmall.domain.review.entity;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@Document(collation = "review")
public class Review {
    @Id
    private String id;

    @Pattern(regexp = "^[0-5]$")
    private Integer rating;

    @NotBlank
    @DBRef(db = "user")
    private User writer;

    @NotBlank
    private String contents;

    @NotBlank
    @DBRef(db = "product")
    private Product product;

    private String imageURL;

    @Builder
    public Review(Integer rating, User writer, String contents, Product product, String imageURL) {
        this.rating = rating;
        this.writer = writer;
        this.contents = contents;
        this.product = product;
        this.imageURL = imageURL;
    }
}
