package com.example.shoppingmall.domain.product.service;

import com.example.shoppingmall.domain.product.controller.dto.request.ProductModifyRequest;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.service.facade.ProductFacade;
import com.example.shoppingmall.global.facade.DateFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProductModifyService {
    private final ProductFacade productFacade;
    private final DateFacade dateFacade;

    public void execute(ProductModifyRequest request, String id) {
        Product product = productFacade.getProductById(id);
        Date now = dateFacade.getNowDate();


        product.Modify(request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                now,
                request.getImageURL());
    }
}
