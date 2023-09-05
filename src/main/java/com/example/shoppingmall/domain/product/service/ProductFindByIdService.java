package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFindByIdService {
    private final ProductRepository productRepository;

    public ProductResponse execute(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); // 예외 처리 예정

        return ProductResponse.builder()
                .seller(product.getSeller())
                .title(product.getTitle())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .postDate(product.getPostdate())
                .imageURL(product.getImageURL())
                .build();
    }
}
