package com.CommentControlSystem.CommentControlSystem.Product.controller;

import com.CommentControlSystem.CommentControlSystem.General.dto.RestResponse;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<RestResponse<ProductDto>> createProduct(@RequestBody ProductSaveRequestDto productDTO) {
        ProductDto productDto = productService.save(productDTO);
        return ResponseEntity
                .ok(RestResponse.of(productDto));
    }
}
