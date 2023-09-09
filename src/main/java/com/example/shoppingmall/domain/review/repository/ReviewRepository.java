package com.example.shoppingmall.domain.review.repository;

import com.example.shoppingmall.domain.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findByProductId(String id);
}
