package com.CommentControlSystem.Product.dto;

import com.CommentControlSystem.General.enums.StatusType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private StatusType statusType;
}
