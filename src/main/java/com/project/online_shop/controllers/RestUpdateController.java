package com.project.online_shop.controllers;

import com.project.online_shop.domain.Products;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestUpdateController {

    private ProductsService productsService;

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

    @GetMapping (value = {"/show/{id}"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Object> shower(@PathVariable("id") Long id) {
        Products products = productsService.getProductById(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
