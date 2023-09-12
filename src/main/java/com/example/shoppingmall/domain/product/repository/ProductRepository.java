package com.example.shoppingmall.domain.product.repository;

import com.example.shoppingmall.domain.product.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    @Query(sort = "{postedDate: -1}")
    List<Product> findByCategory(String category);
    @Query(sort = "{postedDate: -1}")
    List<Product> findBySellerId(String id);

}
