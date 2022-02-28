package com.CommentControlSystem.CommentControlSystem.Product.dto;

import com.CommentControlSystem.CommentControlSystem.General.enums.StatusType;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private StatusType statusType;
}
