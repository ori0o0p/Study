package com.example.shoppingmall.domain.product.repository;

import com.example.shoppingmall.domain.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<List<Product>> findByCategory(String category);
}
