package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.request.ModifyStockRequest;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ModifyStockService {
    private final ProductFacade productFacade;

    public void execute(ModifyStockRequest request) {
        Product product = productFacade.getProductById(request.getProductId());
        product.modifyStock(request.getStock());
    }

}
