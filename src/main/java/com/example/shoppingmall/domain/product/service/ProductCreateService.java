package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.request.ProductRequest;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProductCreateService {
    private final ProductRepository productRepository;
    private final UserFacade userFacade;

    public void execute(ProductRequest request) {
        User user = userFacade.getUser();

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
}
