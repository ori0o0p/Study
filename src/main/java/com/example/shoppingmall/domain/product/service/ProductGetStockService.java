package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGetStockService {
    private final ProductRepository productRepository;

    public Integer execute(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); // 예외 처리 예정
        return product.getStock();
    }
}
