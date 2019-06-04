package com.project.online_shop.service;

import com.project.online_shop.domain.Categories;
import com.project.online_shop.repository.ProductsRepository;
import com.project.online_shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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

    @Override
    public Set<Products> findByCategories(Set<Categories> categories) {
        return productsRepository.findByCategories(categories);
    }

    @Override
    public void uploadImage(MultipartFile upload, String uploadPath, Products product) {
        if (upload != null && !upload.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String resultFilename = UUID.randomUUID() + "." + upload.getOriginalFilename();

            try (FileOutputStream fos = new FileOutputStream(uploadPath + resultFilename)){
                byte[] buffer = upload.getBytes();
                fos.write(buffer, 0, buffer.length);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            product.setImage(resultFilename);
            productsRepository.save(product);
        }
    }
}
