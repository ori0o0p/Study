package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDeleteService {
    private final ProductRepository productRepository;

    public void execute(String id) {
        productRepository.deleteById(id);
    }

}
