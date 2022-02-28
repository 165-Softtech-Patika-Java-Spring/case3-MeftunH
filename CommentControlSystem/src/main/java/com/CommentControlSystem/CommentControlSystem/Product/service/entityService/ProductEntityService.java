package com.CommentControlSystem.CommentControlSystem.Product.service.entityService;

import com.CommentControlSystem.CommentControlSystem.General.service.BaseEntityService;
import com.CommentControlSystem.CommentControlSystem.Product.dao.ProductDao;
import com.CommentControlSystem.CommentControlSystem.Product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductEntityService extends BaseEntityService<Product, ProductDao> {
    public ProductEntityService(ProductDao dao) {
        super(dao);
    }
    public List<Product> findAll() {
        return getDao().findAll();
    }

}
