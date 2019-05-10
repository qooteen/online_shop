package com.project.online_shop.service;

import com.project.online_shop.repository.ProductsRepository;
import com.project.online_shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("productsService")
public class ProductsServiceImpl implements ProductsService{

    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Products getProductById(Long id) {
        return productsRepository.getOne(id);
    }

    @Override
    public void saveProduct(Products products) {
        productsRepository.save(products);
    }

    @Override
    public void updateProduct(Products products) {
        productsRepository.save(products);
    }

    @Override
    public void deleteProduct(Products products) {
        productsRepository.delete(products);
    }

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> findByDescription(String description) {
        return productsRepository.findByDescription(description);
    }
}
