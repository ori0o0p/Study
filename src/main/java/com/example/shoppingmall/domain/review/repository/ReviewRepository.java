package com.example.shoppingmall.domain.review.repository;

import com.example.shoppingmall.domain.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
