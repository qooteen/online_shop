package com.project.online_shop.controllers;


import com.project.online_shop.domain.Orders;
import com.project.online_shop.domain.Products;
import com.project.online_shop.domain.Products_buy;
import com.project.online_shop.domain.Users;
import com.project.online_shop.service.OrdersService;
import com.project.online_shop.service.ProductsService;
import com.project.online_shop.service.UsersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
public class RestAdminController {

    private ProductsService productsService;

    private OrdersService ordersService;

    private UsersService usersService;

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping (value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Products data) {
        Products products = productsService.getProductById(id);

        products.setManufacturer_id(data.getManufacturer_id());
        products.setCategories(data.getCategories());
        products.setTitle(data.getTitle());
        products.setAccessible(data.getAccessible());
        products.setPrice(data.getPrice());
        products.setShort_description(data.getShort_description());
        products.setDescription(data.getDescription());
        products.setQuantity(data.getQuantity());
        productsService.saveProduct(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping (value = "/update/{id}")
    public ResponseEntity<Object> updatePic(@PathVariable("id") Long id, MultipartHttpServletRequest request) {
        Products products = productsService.getProductById(id);
        Iterator<String> itr =  request.getFileNames();
        MultipartFile upload = null;

        while(itr.hasNext()){
            upload = (MultipartFile)request.getFile(itr.next());
        }

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

                String resultFilename = upload.getOriginalFilename();

                try (FileOutputStream fos = new FileOutputStream(uploadPath + resultFilename)) {
                    byte[] buffer = upload.getBytes();
                    fos.write(buffer, 0, buffer.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                products.setImage(resultFilename);
                productsService.saveProduct(products);

            }
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
