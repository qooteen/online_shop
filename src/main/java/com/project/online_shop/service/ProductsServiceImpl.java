package com.project.online_shop.service;

import com.project.online_shop.dao.ProductsRepo;
import com.project.online_shop.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService{

    private ProductsRepo productsRepo;

    @Autowired
    public void setProductsRepo(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    @Override
    public Products getProductById(Long id) {
        return productsRepo.getOne(id);
    }

    @Override
    public void saveProduct(Products products) {
        productsRepo.save(products);
    }

    @Override
    public void updateProduct(Products products) {
        productsRepo.save(products);
    }

    @Override
    public void deleteProduct(Products products) {
        productsRepo.delete(products);
    }

    @Override
    public List<Products> findAll() {
        return productsRepo.findAll();
    }
}
