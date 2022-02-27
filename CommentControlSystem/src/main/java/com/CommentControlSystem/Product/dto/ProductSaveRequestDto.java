package com.CommentControlSystem.Product.dto;

import com.CommentControlSystem.General.enums.StatusType;

import java.math.BigDecimal;

public class ProductSaveRequestDto {
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private StatusType statusType;
}
