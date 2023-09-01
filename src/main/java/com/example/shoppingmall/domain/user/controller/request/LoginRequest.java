package com.example.shoppingmall.domain.user.controller.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LoginRequest {
    private String email;
    private String password;

}
