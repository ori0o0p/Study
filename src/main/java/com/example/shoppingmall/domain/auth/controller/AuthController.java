package com.example.shoppingmall.domain.auth.controller;

import com.example.shoppingmall.domain.auth.controller.dto.request.LoginRequest;
import com.example.shoppingmall.domain.auth.controller.dto.request.SignupRequest;
import com.example.shoppingmall.domain.auth.controller.dto.response.LoginResponse;
import com.example.shoppingmall.domain.auth.service.LoginService;
import com.example.shoppingmall.domain.auth.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        signupService.execute(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.execute(request);
    }

}
