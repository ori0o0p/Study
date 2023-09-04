package com.example.shoppingmall.domain.product.service;


import com.example.shoppingmall.domain.product.controller.dto.request.ProductRequest;
import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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

    public List<ProductResponse> allList() {
        List<Product> productList = productRepository.findAll();

        return productList.stream().map(p -> new ProductResponse(
                p.getTitle(),
                p.getDescription(),
                p.getCategory(),
                p.getPrice(),
                p.getPostdate(),
                p.getImageURL()
        )).toList();

    }

    public List<ProductResponse> categoryList(String category) {
        List<Product> productList = productRepository.findByCategory(category);

        return productList.stream().map(p -> new ProductResponse(
                p.getCategory(),
                p.getTitle(),
                p.getDescription(),
                p.getPrice(),
                p.getPostdate(),
                p.getImageURL()
        )).toList();
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

}
