package com.example.shoppingmall.domain.purchase.controller;

import com.example.shoppingmall.domain.purchase.controller.dto.request.PurchaseRequest;
import com.example.shoppingmall.domain.purchase.controller.dto.response.PurchaseResponse;
import com.example.shoppingmall.domain.purchase.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    public PurchaseResponse purchase(@RequestBody PurchaseRequest request) {
        return purchaseService.execute(request);
    }

}
