package com.example.shoppingmall.domain.purchase.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PurchaseResponse {
    private Integer stock;

    private Boolean isSuccess;
}
