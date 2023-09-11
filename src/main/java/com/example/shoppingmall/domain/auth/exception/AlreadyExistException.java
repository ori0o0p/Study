package com.example.shoppingmall.domain.auth.exception;

import com.example.shoppingmall.global.exception.CustomException;
import com.example.shoppingmall.global.exception.ErrorCode;

public class AlreadyExistException extends CustomException {
    public static final CustomException EXCEPTION = new AlreadyExistException();

    private AlreadyExistException() {
        super(ErrorCode.ALREADY_EXIST);
    }

}
