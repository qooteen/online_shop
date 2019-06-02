package com.project.online_shop.controllers;

import com.project.online_shop.domain.Products;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.File;
import java.util.Iterator;

@RestController
public class RestUpdateController {

    private ProductsService productsService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping (value = {"/update/{id}"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Object> updater(@PathVariable("id") Long id, @RequestBody Products data, @ModelAttribute Products prod) {

        Products products = productsService.getProductById(id);
        products.setTitle(data.getTitle());
        products.setAccessible(data.getAccessible());
        products.setPrice(data.getPrice());
        products.setShort_description(data.getShort_description());
        products.setDescription(data.getDescription());
        products.setQuantity(data.getQuantity());
        productsService.saveProduct(products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping (value = "/update/{id}")
    public ResponseEntity<Object> updatePic(@PathVariable("id") Long id, @ModelAttribute Products prod) {
        Products products = productsService.getProductById(id);
        products.setManufacturer_id(prod.getManufacturer_id());
        products.setCategories(prod.getCategories());

        MultipartFile upload = prod.getUpload();

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        if (upload != null && !upload.getOriginalFilename().isEmpty()) {
            File[] files = uploadDir.listFiles();
            if (files != null && files.length != 0)
                for (File file : files)
                    if (file.getName().equals(products.getImage())) {
                        file.delete();
                        break;
                    }
            productsService.uploadImage(upload, uploadPath, products);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
