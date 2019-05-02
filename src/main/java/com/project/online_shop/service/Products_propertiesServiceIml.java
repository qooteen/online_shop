package com.project.online_shop.service;

import com.project.online_shop.dao.Products_propertiesRepo;
import com.project.online_shop.entity.Products_properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Products_propertiesServiceIml implements Products_propertiesService{

    private Products_propertiesRepo products_propertiesRepo;

    @Autowired
    public void setProducts_propertiesRepo(Products_propertiesRepo products_propertiesRepo) {
        this.products_propertiesRepo = products_propertiesRepo;
    }

    @Override
    public Products_properties getProducts_propertyById(Long id) {
        return products_propertiesRepo.getOne(id);
    }

    @Override
    public void saveProducts_property(Products_properties products_properties) {
        products_propertiesRepo.save(products_properties);
    }

    @Override
    public void updateProducts_property(Products_properties products_properties) {
        products_propertiesRepo.save(products_properties);
    }

    @Override
    public void deleteProducts_property(Products_properties products_properties) {
        products_propertiesRepo.delete(products_properties);
    }

    @Override
    public List<Products_properties> findAll() {
        return products_propertiesRepo.findAll();
    }
}
