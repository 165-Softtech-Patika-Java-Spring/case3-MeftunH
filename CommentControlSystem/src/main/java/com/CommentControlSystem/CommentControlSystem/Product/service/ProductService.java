package com.CommentControlSystem.CommentControlSystem.Product.service;

import com.CommentControlSystem.CommentControlSystem.General.enums.StatusType;
import com.CommentControlSystem.CommentControlSystem.Product.converter.ProductMapper;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import com.CommentControlSystem.CommentControlSystem.Product.service.entityService.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductEntityService productEntityService;

    public ProductDto save(ProductSaveRequestDto requestDto) {
        Product product = ProductMapper.INSTANCE.convertToProduct(requestDto);
        product.setStatusType(StatusType.ACTIVE);

        product = productEntityService.save(product);

        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);

        return productDto;
    }
}
