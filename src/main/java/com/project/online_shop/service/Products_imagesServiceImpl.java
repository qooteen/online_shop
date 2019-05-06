package com.project.online_shop.service;

import com.project.online_shop.repository.Products_imagesRepository;
import com.project.online_shop.domain.Products_images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("products_imagesService")
public class Products_imagesServiceImpl implements Products_imagesService{

    @Autowired
    private Products_imagesRepository products_imagesRepository;

    @Override
    public Products_images getProducts_imageById(Long id) {
        return products_imagesRepository.getOne(id);
    }

    @Override
    public void saveProducts_image(Products_images products_images) {
        products_imagesRepository.save(products_images);
    }

    @Override
    public void updateProducts_image(Products_images products_images) {
        products_imagesRepository.save(products_images);
    }

    @Override
    public void deleteProducts_image(Products_images products_images) {
        products_imagesRepository.delete(products_images);
    }

    @Override
    public List<Products_images> findAll() {
        return products_imagesRepository.findAll();
    }
}
