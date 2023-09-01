package com.example.shoppingmall.domain.user.controller.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignupRequest {
    private String email;
    private String name;
    private String password;
    private String authCode;

}
