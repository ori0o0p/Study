package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.entity.ProductDetails;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.review.controller.dto.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductFindAllService {
    private final ProductRepository productRepository;

    public List<ProductResponse> execute() {
        List<Product> productList = productRepository.findAll();

        return productList.stream().map(p -> new ProductResponse(
                p.getSeller(),
                new ProductDetails(
                        p.getTitle(),
                        p.getDescription(),
                        p.getCategory(),
                        p.getPrice(),
                        p.getImageURL()),
                p.getReview().stream().map(r -> new ReviewResponse(
                        r.getRating(),
                        r.getContent(),
                        r.getCreatedDate(),
                        r.getImageURL()
                )).toList(),
                p.getPostedDate()
        )).toList();
    }

}
