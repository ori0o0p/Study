package com.example.shoppingmall.domain.user.controller.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private String accessToken;

}
