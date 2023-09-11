package com.example.shoppingmall.domain.auth.service;

import com.example.shoppingmall.domain.auth.controller.dto.request.LoginRequest;
import com.example.shoppingmall.domain.auth.controller.dto.response.LoginResponse;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.auth.exception.PasswordNotMatchedException;
import com.example.shoppingmall.domain.user.exception.UserNotFoundException;
import com.example.shoppingmall.domain.user.repository.UserRepository;
import com.example.shoppingmall.domain.user.service.facade.UserFacade;
import com.example.shoppingmall.global.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final UserFacade userFacade;

    public LoginResponse execute(LoginRequest request) {
        User user = userFacade.getUserById(request.getEmail());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordNotMatchedException.EXCEPTION;
        }
        String accessToken = jwtProvider.createAccessToken(request.getEmail());

        return LoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
