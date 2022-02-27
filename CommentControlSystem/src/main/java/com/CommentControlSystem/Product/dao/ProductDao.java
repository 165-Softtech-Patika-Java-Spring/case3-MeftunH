package com.CommentControlSystem.Product.dao;

import com.CommentControlSystem.Product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
