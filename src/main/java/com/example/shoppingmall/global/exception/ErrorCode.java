package com.example.shoppingmall.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ALREADY_EXIST(400, "user already exist"),
    PASSWORD_NOT_MATCHES(400, "incorrect password"),
    CREATION_OR_GENERATION_ERROR_FAILED(400, "creation/generation failed"),
    INVALID_DATA(400, "invalid data"),

    REVIEW_NOT_FOUND(404, "review not found"),
    PRODUCT_NOT_FOUND(404,"product not found"),
    USER_NOT_FOUND(404, "user not found");

    private final int httpStatus;
    private final String message;
}