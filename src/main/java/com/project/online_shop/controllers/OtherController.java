package com.project.online_shop.controllers;

import com.project.online_shop.domain.*;
import com.project.online_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OtherController {

    @Value("${upload.path}")
    private String uploadPath;

    private ProductsService productsService;
    private ManufacturersService manufacturersService;
    private CategoryService categoryService;
    private UsersService usersService;
    private OrdersService ordersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setManufacturersService(ManufacturersService manufacturersService) {
        this.manufacturersService = manufacturersService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/update/{id}")
    public String updatePage(@PathVariable("id") Long id, Map<String, Object> map) {
        Products products = productsService.getProductById(id);
        map.put("prod", products);

        Map<Categories, String> map1 = new HashMap<>();

        List<Categories> categoriesList = categoryService.findAll();
        for (Categories categories : categoriesList)
            map1.put(categories, categories.getLogo());

        Map<Long, String> map2 = new HashMap<>();

        List<Manufacturers> manufacturersList = manufacturersService.findAll();
        for (Manufacturers manufacturers : manufacturersList)
            map2.put(manufacturers.getManufacturer_id(), manufacturers.getLogo());

        map.put("map", map1);
        map.put("map2", map2);
        return "update";
    }

    @PostMapping(value = "/update/{id}")
    public String updatePic(@PathVariable("id") Long id, @ModelAttribute Products prod) {
        Products products = productsService.getProductById(id);
        products.setManufacturer_id(prod.getManufacturer_id());
        products.setCategories(prod.getCategories());
        productsService.saveProduct(products);
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
        return "redirect:/";
    }

    @RequestMapping(value = {"/info"})
    public String infoPage(Model model) {
        UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersService.findByUsername(userDetail.getUsername());
        List<Orders> orders = ordersService.findAllByUser(user);
        model.addAttribute("orders", orders);
        return "history";
    }
}
