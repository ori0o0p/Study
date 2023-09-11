package com.example.shoppingmall.global.security.exception;

import com.example.shoppingmall.global.exception.CustomException;
import com.example.shoppingmall.global.exception.error.ErrorCode;

public class JwtCreationFailedException extends CustomException {
    public static final CustomException EXCEPTION = new JwtCreationFailedException();

    private JwtCreationFailedException() {
        super(ErrorCode.CREATION_OR_GENERATION_ERROR_FAILED);
    }
}
