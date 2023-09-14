package com.example.shoppingmall.domain.user.service.facade;

import com.example.shoppingmall.domain.product.exception.ProductNotFoundException;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.exception.UserNotFoundException;
import com.example.shoppingmall.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }

    public User getUserByEmail(String email) {
        return userRepository.findById(email)
                .orElseThrow(() -> ProductNotFoundException.EXCEPTION);
    }

}
