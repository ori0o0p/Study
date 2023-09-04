package com.example.shoppingmall.domain.product.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Document(collation = "product")
public class Product {
    @Id
    private String id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Integer price;
    @NotBlank
    private Integer stock;
    @NotBlank
    private String category;
    @NotBlank
    private Date postdate;
}
