package com.project.online_shop.service;

import com.project.online_shop.entity.Products_images;
import java.util.List;

public interface Products_imagesService {

    Products_images getProducts_imageById(Long id);

    void saveProducts_image(Products_images products_images);

    void updateProducts_image(Products_images products_images);

    void deleteProducts_image(Products_images products_images);

    List<Products_images> findAll();
}
