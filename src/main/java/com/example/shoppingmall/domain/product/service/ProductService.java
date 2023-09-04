package com.example.shoppingmall.domain.product.service;


import com.example.shoppingmall.domain.product.controller.dto.request.ProductRequest;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest request) {
        User user = userRepository.findByEmail(request.getSellerEmail())
                .orElseThrow(() -> new RuntimeException()); // 예외 처리 예정

        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        productRepository.save(Product.builder()
                        .seller(user)
                        .title(request.getTitle())
                        .description(request.getDescription())
                        .category(request.getCategory())
                        .price(request.getPrice())
                        .stock(request.getStock())
                        .postdate(date)
                        .imageURL(request.getImageURL())
                .build());
    }
    

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}
