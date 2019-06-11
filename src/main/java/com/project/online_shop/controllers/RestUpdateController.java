package com.project.online_shop.controllers;

import com.project.online_shop.domain.Products;
import com.project.online_shop.service.ProductsService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class RestUpdateController {

    @Value("${upload.path}")
    private String uploadPath;

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping (value = {"/update/{id}"}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Object> updater(@PathVariable("id") Long id, @RequestBody Products data) {

        Products products = productsService.getProductById(id);

        if (data.getImage() != null && !data.getImage().equals("")) {
            productsService.deleteImage(uploadPath, products);
            products.setImage(convertToImage(data.getImage()));
        }
        products.setCategories(data.getCategories());
        products.setManufacturer(data.getManufacturer());
        products.setProperty(data.getProperty());
        products.setTitle(data.getTitle());
        products.setAccessible(data.getAccessible());
        products.setPrice(data.getPrice());
        products.setShort_description(data.getShort_description());
        products.setDescription(data.getDescription());
        products.setQuantity(data.getQuantity());
        productsService.saveProduct(products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping (value = {"/show/{id}"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Products> shower(@PathVariable("id") Long id) {
        Products product = productsService.getProductById(id);
        return new ResponseEntity<Products>(product, HttpStatus.OK);
    }

    private String convertToImage(String base64) {
            String type = base64.substring(base64.indexOf("image/") + 6, base64.indexOf(";base64"));
            String name = UUID.randomUUID() + "." + type;
            try (FileOutputStream fos = new FileOutputStream(uploadPath + name)) {
                byte[] bytes = Base64.decodeBase64(base64.split(",")[1]);
                fos.write(bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return name;
    }
}
