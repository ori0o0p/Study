package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.request.ProductModifyRequest;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductModifyService {
    private final ProductRepository productRepository;

    public void execute(ProductModifyRequest request, String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); // 예외 처리 예정

        product.Modify(request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImageURL());
    }
}
