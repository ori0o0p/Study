package com.example.shoppingmall.domain.product.controller;

import com.example.shoppingmall.domain.product.controller.dto.request.ProductModifyRequest;
import com.example.shoppingmall.domain.product.controller.dto.request.ProductRequest;
import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductRequest request) {
        productService.create(request);
    }

    @PostMapping("/modify")
    public void modifyProduct(@RequestBody ProductModifyRequest request,
                              @PathVariable String id) {
        productService.modify(request, id);
    }

    @GetMapping("{id}")
    public ProductResponse findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @GetMapping("/search/{category}")
    public List<ProductResponse> findByCategory(@PathVariable String category) {
        return productService.categoryList(category);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.allList();
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable String id) {
        productService.delete(id);
    }


}
