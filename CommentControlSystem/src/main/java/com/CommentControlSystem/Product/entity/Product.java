package com.CommentControlSystem.Product.entity;

import com.CommentControlSystem.General.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product extends BaseEntity {

    @Id
    private Long id;
    private String name;
    private String description;
    private String category;
    private String image;
    private String price;
    private String quantity;
    private String status;
    private String createdBy;
    private String createdDate;
    private String updatedBy;

}
