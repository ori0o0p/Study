package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGetStockService {
    private final ProductFacade productFacade;

    public Integer execute(String id) {
        Product product = productFacade.getProductById(id);
        return product.getStock();
    }
}
