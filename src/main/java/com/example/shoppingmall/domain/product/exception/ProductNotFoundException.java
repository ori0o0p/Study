package com.example.shoppingmall.domain.product.exception;

import com.example.shoppingmall.global.exception.CustomException;
import com.example.shoppingmall.global.exception.error.ErrorCode;

public class ProductNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new ProductNotFoundException();

    private ProductNotFoundException() {
        super(ErrorCode.PRODUCT_NOT_FOUND);
    }

}
