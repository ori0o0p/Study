package com.example.shoppingmall.domain.user.exception;

import com.example.shoppingmall.global.exception.CustomException;
import com.example.shoppingmall.global.exception.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
