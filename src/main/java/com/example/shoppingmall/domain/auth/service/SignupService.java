package com.example.shoppingmall.domain.auth.service;

import com.example.shoppingmall.domain.auth.exception.AlreadyExistException;
import com.example.shoppingmall.domain.auth.controller.dto.request.SignupRequest;
import com.example.shoppingmall.domain.user.entity.Role;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void execute(SignupRequest request) {
        if (userRepository.findByName(request.getName()) .isPresent() ||
            userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw AlreadyExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CUSTOMER)
                .build());
    }
}
