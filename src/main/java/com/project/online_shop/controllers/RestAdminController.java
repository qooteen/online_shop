package com.project.online_shop.controllers;


import com.project.online_shop.domain.Products;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
public class RestAdminController {

    private ProductsService productsService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping (value = "/update/{id}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Products data) { //@RequestParam(required = false) MultipartFile upload) {

        Products products = productsService.getProductById(id);

//        if (upload != null && !upload.getOriginalFilename().isEmpty()) {
//
//            File uploadDir = new File(uploadPath);
//
//            if (!uploadDir.exists()) {
//                uploadDir.mkdir();
//            }
//
//            File[] files = uploadDir.listFiles();
//            if (files != null && files.length != 0)
//            for (File file: files)
//                if (file.getName().equals(products.getImage()))
//                    file.delete();
//
//
//            String uuidFile = UUID.randomUUID().toString();
//            String resultFilename = uuidFile + "." + upload.getOriginalFilename();
//
//            try (FileOutputStream fos = new FileOutputStream(uploadPath + resultFilename)){
//                byte[] buffer = upload.getBytes();
//                fos.write(buffer, 0, buffer.length);
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            products.setImage(resultFilename);
//        }

        products.setManufacturer_id(data.getManufacturer_id());
        products.setCategories(data.getCategories());
        products.setTitle(data.getTitle());
        products.setAccessible(data.getAccessible());
        products.setPrice(data.getPrice());
        products.setShort_description(data.getShort_description());
        products.setDescription(data.getDescription());
        productsService.saveProduct(products);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }
}
