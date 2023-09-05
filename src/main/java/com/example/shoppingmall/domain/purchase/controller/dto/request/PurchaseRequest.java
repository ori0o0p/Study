package com.example.shoppingmall.domain.purchase.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PurchaseRequest {
    private String id;

    private String user;

    private Integer amount;
}
