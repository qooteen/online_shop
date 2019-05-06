package com.project.online_shop.service;

import com.project.online_shop.repository.Products_propertiesRepository;
import com.project.online_shop.domain.Products_properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("products_propertiesService")
public class Products_propertiesServiceIml implements Products_propertiesService{

    @Autowired
    private Products_propertiesRepository products_propertiesRepository;

    @Override
    public Products_properties getProducts_propertyById(Long id) {
        return products_propertiesRepository.getOne(id);
    }

    @Override
    public void saveProducts_property(Products_properties products_properties) {
        products_propertiesRepository.save(products_properties);
    }

    @Override
    public void updateProducts_property(Products_properties products_properties) {
        products_propertiesRepository.save(products_properties);
    }

    @Override
    public void deleteProducts_property(Products_properties products_properties) {
        products_propertiesRepository.delete(products_properties);
    }

    @Override
    public List<Products_properties> findAll() {
        return products_propertiesRepository.findAll();
    }
}
