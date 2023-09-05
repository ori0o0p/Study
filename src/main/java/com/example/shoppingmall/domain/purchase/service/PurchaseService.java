package com.example.shoppingmall.domain.purchase.service;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.product.service.ProductGetStockService;
import com.example.shoppingmall.domain.purchase.controller.dto.request.PurchaseRequest;
import com.example.shoppingmall.domain.purchase.controller.dto.response.PurchaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final ProductRepository productRepository;
    private final ProductGetStockService productGetStockService;

    public PurchaseResponse execute(PurchaseRequest request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException()); //예외 처리 예정

        Integer stock = productGetStockService.execute(product.getId());

        if (stock < request.getAmount()) {
            log.error("재고가 부족합니다.");
            return PurchaseResponse.builder()
                    .stock(stock)
                    .success(false)
                    .build();
        } else {
            stock -= request.getAmount();
        }

        return PurchaseResponse.builder()
                .stock(stock)
                .success(true)
                .build();

    }

}
