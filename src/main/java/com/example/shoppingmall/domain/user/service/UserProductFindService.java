package com.example.shoppingmall.domain.user.service;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.review.controller.dto.response.ReviewResponse;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProductFindService {
    private final UserFacade userFacade;
    private final ProductRepository productRepository;

    public List<ProductResponse> execute(String email) {
        User user = userFacade.getUserByEmail(email);
        List<Product> productList = productRepository.findBySellerId(user.getId());

        return productList.stream().map(p -> new ProductResponse(
                p.getTitle(),
                p.getDescription(),
                p.getCategory(),
                p.getPrice(),
                p.getPostedDate(),
                p.getImageURL()
        )).toList();
    }

}
