package com.CommentControlSystem.CommentControlSystem.Product.service;

import com.CommentControlSystem.CommentControlSystem.General.enums.StatusType;
import com.CommentControlSystem.CommentControlSystem.Product.converter.ProductMapper;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import com.CommentControlSystem.CommentControlSystem.Product.service.entityService.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    public List<ProductDto> findAll() {
        List<Product> products = productEntityService.findAll();

        return ProductMapper.INSTANCE.convertToProductDtoList(products);
    }

    public ProductDto findById(Long id) {
       Product product = productEntityService.getByIdWithControl(id);

       ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);

        return productDto;
    }

    public void delete(Long id) {
        Product product = productEntityService.getByIdWithControl(id);

        productEntityService.delete(product);
    }

    public ProductDto updateProductPrice(Long id, BigDecimal price) {
        Product product = productEntityService.getByIdWithControl(id);
        product.setPrice(price);

        product = productEntityService.save(product);

        ProductDto productDto = ProductMapper.INSTANCE.convertToProductDto(product);

        return productDto;
    }
}
