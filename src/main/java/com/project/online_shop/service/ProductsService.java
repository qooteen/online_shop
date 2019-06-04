package com.project.online_shop.service;

import com.project.online_shop.domain.Categories;
import com.project.online_shop.domain.Products;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface ProductsService {

    Products getProductById(Long id);

    void saveProduct(Products products);

    void updateProduct(Products products);

    void deleteProduct(Products products);

    List<Products> findAll();

    List<Products> findByDescription(String description);

    Set<Products> findByCategories(Set<Categories> categories);

    void uploadImage(MultipartFile upload, String uploadPath, Products product);
}
