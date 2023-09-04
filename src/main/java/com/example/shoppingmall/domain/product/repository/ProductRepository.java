package com.example.shoppingmall.domain.product.repository;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByCategory(String category);

}
