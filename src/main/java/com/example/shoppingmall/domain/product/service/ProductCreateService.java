package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.request.ProductRequest;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.entity.ProductDetails;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.service.facade.UserFacade;
import com.example.shoppingmall.global.facade.DateFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProductCreateService {
    private final ProductRepository productRepository;
    private final UserFacade userFacade;
    private final DateFacade dateFacade;

    public void execute(ProductRequest request) {
        User user = userFacade.getUser();
        Date now = dateFacade.getNowDate();

        ProductDetails details = ProductDetails.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .price(request.getPrice())
                .imageURL(request.getImageURL())
                .build();

        productRepository.save(Product.builder()
                .seller(user)
                .details(details)
                .stock(request.getStock())
                .postedDate(now)
                .build());
    }
}
