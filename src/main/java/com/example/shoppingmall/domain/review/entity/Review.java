package com.example.shoppingmall.domain.review.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
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

    @Email
    @NotBlank
    private String writerEmail;

    @NotBlank
    private String contents;

    @NotBlank
    private String productId;

    private String imageURL;

    @Builder
    public Review(Integer rating, String writerEmail, String contents, String productId, String imageURL) {
        this.rating = rating;
        this.writerEmail = writerEmail;
        this.contents = contents;
        this.productId = productId;
        this.imageURL = imageURL;
    }
}
