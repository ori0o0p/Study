package com.example.shoppingmall.domain.user.service;

import com.example.shoppingmall.domain.user.controller.dto.request.LoginRequest;
import com.example.shoppingmall.domain.user.controller.dto.response.LoginResponse;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.repository.UserRepository;
import com.example.shoppingmall.global.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public LoginResponse execute(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(RuntimeException::new); // 예외 처리 예정
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException(); // 예외 처리 예정
        }
        String accessToken = jwtProvider.createAccessToken(request.getEmail());

        return LoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}
