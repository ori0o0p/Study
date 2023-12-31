package com.example.shoppingmall.domain.product.controller;

import com.example.shoppingmall.domain.product.controller.dto.request.ModifyStockRequest;
import com.example.shoppingmall.domain.product.controller.dto.request.ProductModifyRequest;
import com.example.shoppingmall.domain.product.controller.dto.request.ProductRequest;
import com.example.shoppingmall.domain.product.controller.dto.response.ProductResponse;
import com.example.shoppingmall.domain.product.entity.Product;
import com.example.shoppingmall.domain.product.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductCreateService productCreateService;
    private final ProductUpdateService productModifyService;
    private final ProductDeleteService productDeleteService;
    private final ProductFindAllService productFindAllService;
    private final ProductFindByIdService productFindByIdService;
    private final ProductGetCategoryListService productGetCategoryListService;
    private final UpdateStockService modifyStockService;

    @PostMapping
    public void createProduct(@RequestBody ProductRequest request) {
        productCreateService.execute(request);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody ProductModifyRequest request,
                                 @PathVariable String id) {
        return productModifyService.execute(request, id);
    }

    @GetMapping("/view/{id}")
    public ProductResponse findById(@PathVariable String id) {
        return productFindByIdService.execute(id);
    }

    @GetMapping("/search/{category}")
    public List<ProductResponse> findByCategory(@PathVariable String category) {
        return productGetCategoryListService.execute(category);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productFindAllService.execute();
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable String id) {
        productDeleteService.execute(id);
    }

    @PostMapping("/stock")
    public void updateStock(@RequestBody ModifyStockRequest request) {
        modifyStockService.execute(request);
    }

}
