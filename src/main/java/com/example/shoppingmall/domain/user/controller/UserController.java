package com.example.shoppingmall.domain.user.controller;

import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.user.entity.User;
import com.example.shoppingmall.domain.user.service.UserProductFindService;
import com.example.shoppingmall.domain.user.service.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;
    private final UserProductFindService userProductFindService;

    @GetMapping
    public User getUser() {
        return userFacade.getUser();
    }

    @GetMapping("{id}")
    public List<ProductResponse> getProduct(@PathVariable String id) {
        return userProductFindService.execute(id);
    }

}
