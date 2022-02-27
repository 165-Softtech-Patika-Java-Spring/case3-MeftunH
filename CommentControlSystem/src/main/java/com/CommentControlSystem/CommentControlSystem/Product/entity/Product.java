package com.CommentControlSystem.CommentControlSystem.Product.entity;

import com.CommentControlSystem.CommentControlSystem.General.entity.BaseEntity;
import com.CommentControlSystem.CommentControlSystem.General.enums.StatusType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntity {

    @Id
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "Product")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", precision = 19, scale = 2)
    private String description;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS_TYPE", length = 30)
    private StatusType statusType;

}
