package com.example.shoppingmall.domain.product.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyStockRequest {
    private Integer stock;
    private String productId;
}
