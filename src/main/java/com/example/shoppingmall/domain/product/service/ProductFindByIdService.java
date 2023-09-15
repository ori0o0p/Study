package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.entity.ProductDetails;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
import com.example.shoppingmall.domain.review.controller.dto.response.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFindByIdService {
    private final ProductFacade productFacade;

    public ProductResponse execute(String id) {
        Product product = productFacade.getProductById(id);

        ProductDetails details = ProductDetails.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .imageURL(product.getImageURL())
                .build();

        return ProductResponse.builder()
                .seller(product.getSeller())
                .details(details)
                .review(product.getReview().stream().map(r -> new ReviewResponse(
                        r.getRating(),
                        r.getContent(),
                        r.getCreatedDate(),
                        r.getImageURL()
                )).toList())
                .postDate(product.getPostedDate())
                .build();
    }
}
