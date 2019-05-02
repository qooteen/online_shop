package com.project.online_shop.service;

import com.project.online_shop.dao.Products_imagesRepo;
import com.project.online_shop.entity.Products_images;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Products_imagesServiceImpl implements Products_imagesService{

    private Products_imagesRepo products_imagesRepo;

    @Autowired
    public void setProducts_imagesRepo(Products_imagesRepo products_imagesRepo) {
        this.products_imagesRepo = products_imagesRepo;
    }

    @Override
    public Products_images getProducts_imageById(Long id) {
        return products_imagesRepo.getOne(id);
    }

    @Override
    public void saveProducts_image(Products_images products_images) {
        products_imagesRepo.save(products_images);
    }

    @Override
    public void updateProducts_image(Products_images products_images) {
        products_imagesRepo.save(products_images);
    }

    @Override
    public void deleteProducts_image(Products_images products_images) {
        products_imagesRepo.delete(products_images);
    }

    @Override
    public List<Products_images> findAll() {
        return products_imagesRepo.findAll();
    }
}
