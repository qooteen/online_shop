package com.project.online_shop.service;

import com.project.online_shop.domain.Products;
import java.util.List;

public interface ProductsService {

    Products getProductById(Long id);

    void saveProduct(Products products);

    void updateProduct(Products products);

    void deleteProduct(Products products);

    List<Products> findAll();

    List<Products> findByDescription(String description);
}
