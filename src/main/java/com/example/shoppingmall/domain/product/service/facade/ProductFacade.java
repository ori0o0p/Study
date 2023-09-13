package com.example.shoppingmall.domain.product.service.facade;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.exception.ProductNotFoundException;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFacade {
    private final ProductRepository productRepository;

    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> ProductNotFoundException.EXCEPTION);
    }

}
