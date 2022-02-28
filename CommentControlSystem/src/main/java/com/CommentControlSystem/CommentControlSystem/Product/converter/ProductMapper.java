package com.CommentControlSystem.CommentControlSystem.Product.converter;

import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductDto;
import com.CommentControlSystem.CommentControlSystem.Product.dto.ProductSaveRequestDto;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto convertToProductDto(Product product);
    Product convertToProduct(ProductSaveRequestDto productSaveRequestDto);
    List<ProductDto> convertToProductDtoList(List<Product> productDto);
}
