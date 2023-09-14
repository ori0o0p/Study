package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
import com.example.shoppingmall.domain.review.service.ReviewDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductDeleteService {
    private final ProductRepository productRepository;
    private final ProductFacade productFacade;
    private final ReviewDeleteService reviewDeleteService;

    public void execute(String id) {
        Product product = productFacade.getProductById(id);
        productRepository.deleteById(product.getId());
        reviewDeleteService.deleteByProductId(id);
    }

}
