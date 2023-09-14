package com.example.shoppingmall.domain.purchase.service;

import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.repository.ProductRepository;
import com.example.shoppingmall.domain.product.service.ProductGetStockService;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
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
    private final ProductFacade productFacade;

    public PurchaseResponse execute(PurchaseRequest request) {
        Product product = productFacade.getProductById(request.getId());
        Integer stock = productGetStockService.execute(product.getId());

        if (stock < request.getAmount()) {
            log.error("현재 재고 : " + stock + "개 \n 재고가 부족합니다.");
            return PurchaseResponse.builder()
                    .stock(stock)
                    .isSuccess(false)
                    .build();
        } else {
            Integer updatedStock = stock - request.getAmount();
            product.purchaseProduct(updatedStock);
            productRepository.save(product);
            log.info("구매 완료!");
            return PurchaseResponse.builder()
                    .stock(updatedStock)
                    .isSuccess(true)
                    .build();
        }

    }

}
