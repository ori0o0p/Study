package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
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
                p.getTitle(),
                p.getDescription(),
                p.getCategory(),
                p.getPrice(),
                p.getPostedDate(),
                p.getImageURL()
        )).toList();
    }

}
