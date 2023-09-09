package com.example.shoppingmall.domain.user.exception;

import com.example.shoppingmall.global.exception.CustomException;
import com.example.shoppingmall.global.exception.ErrorCode;

public class PasswordNotMatchedException extends CustomException {
    public static final CustomException EXCEPTION = new PasswordNotMatchedException();

    private PasswordNotMatchedException() {
        super(ErrorCode.PASSWORD_NOT_MATCHES);
    }

}
