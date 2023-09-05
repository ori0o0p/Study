package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductGetCategoryListService {
    private final ProductRepository productRepository;

    public List<ProductResponse> execute(String category) {
        List<Product> productList = productRepository.findByCategory(category);

        return productList.stream().map(p -> new ProductResponse(
                p.getSeller(),
                p.getCategory(),
                p.getTitle(),
                p.getDescription(),
                p.getPrice(),
                p.getPostdate(),
                p.getImageURL()
        )).toList();
    }

}
