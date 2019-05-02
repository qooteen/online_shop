package com.project.online_shop.service;

import com.project.online_shop.entity.Products_properties;
import java.util.List;

public interface Products_propertiesService {

    Products_properties getProducts_propertyById(Long id);

    void saveProducts_property(Products_properties products_properties);

    void updateProducts_property(Products_properties products_properties);

    void deleteProducts_property(Products_properties products_properties);

    List<Products_properties> findAll();
}
