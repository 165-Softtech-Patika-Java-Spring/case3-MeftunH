package com.CommentControlSystem.CommentControlSystem.Product.controller;

import com.CommentControlSystem.CommentControlSystem.General.dto.RestResponse;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity  createProduct(@RequestBody ProductSaveRequestDto productDTO) {
        ProductDto productDto = productService.save(productDTO);
        return ResponseEntity
                .ok(RestResponse.of(productDto));
    }
    @GetMapping
    public ResponseEntity getAllProducts() {
        List<ProductDto> productDtoList = productService.findAll();
        return ResponseEntity.
                ok(RestResponse.of(productDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        ProductDto productDto = productService.findById(id);
        return ResponseEntity.
                ok(RestResponse.of(productDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.
                ok(RestResponse.empty());
    }

    @PatchMapping("/{id}/{price}")
    public ResponseEntity updateProductPrice(@PathVariable Long id, @PathVariable BigDecimal price) {
        ProductDto productDto = productService.updateProductPrice(id, price);
        return ResponseEntity.
                ok(RestResponse.of(productDto));
    }
}
