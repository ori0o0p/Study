package com.example.shoppingmall.global.security.exception;

import com.example.shoppingmall.global.exception.CustomException;
import com.example.shoppingmall.global.exception.ErrorCode;

public class InvalidDataException extends CustomException {
    public static final CustomException EXCEPTION = new InvalidDataException();

    private InvalidDataException() {
        super(ErrorCode.INVALID_DATA);
    }
}
