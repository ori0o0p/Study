package com.example.shoppingmall.domain.product.entity;

import com.example.shoppingmall.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
@Document(collation = "product")
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

    @NotBlank
    private Integer price;
    @NotBlank
    private Integer stock;

    @NotBlank
    private Date postdate;
}
