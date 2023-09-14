package com.example.shoppingmall.domain.review.repository;

import com.example.shoppingmall.domain.review.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ReviewRepository extends MongoRepository<Review, String> {

    @Query(sort = "{createdDate: -1}")
    List<Review> findByProductId(String id);

}
