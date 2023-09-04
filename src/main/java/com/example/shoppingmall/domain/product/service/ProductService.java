package com.example.shoppingmall.domain.product.service;


import com.example.shoppingmall.domain.product.controller.dto.request.ProductModifyRequest;
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

    public void create(ProductRequest request) {
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

    public void modify(ProductModifyRequest request, String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); // 예외 처리 예정

        product.Modify(request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImageURL());
    }

    public List<ProductResponse> allList() {
        List<Product> productList = productRepository.findAll();

        return productList.stream().map(p -> new ProductResponse(
                p.getSeller(),
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
                p.getSeller(),
                p.getCategory(),
                p.getTitle(),
                p.getDescription(),
                p.getPrice(),
                p.getPostdate(),
                p.getImageURL()
        )).toList();
    }

    public ProductResponse findById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); // 예외 처리 예정

        return ProductResponse.builder()
                .seller(product.getSeller())
                .title(product.getTitle())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .postDate(product.getPostdate())
                .imageURL(product.getImageURL())
                .build();
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

}
