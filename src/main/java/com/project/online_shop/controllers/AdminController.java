package com.project.online_shop.controllers;

import com.project.online_shop.domain.Categories;
import com.project.online_shop.domain.Manufacturers;
import com.project.online_shop.domain.Products;
import com.project.online_shop.domain.Users;
import com.project.online_shop.service.CategoryService;
import com.project.online_shop.service.ManufacturersService;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private ProductsService productsService;

    private CategoryService categoryService;

    private ManufacturersService manufacturersService;

    @Autowired
    public void setManufacturersService(ManufacturersService manufacturersService) {
        this.manufacturersService = manufacturersService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(Model model) {
        model.addAttribute("product", new Products());

        Map<Categories, String> map = new HashMap<>();
        List<Categories> categoriesList = categoryService.findAll();
        for (Categories categories : categoriesList)
            map.put(categories, categories.getLogo());

        Map<Long, String> map2 = new HashMap<>();
        List<Manufacturers> manufacturersList = manufacturersService.findAll();
        for (Manufacturers manufacturers : manufacturersList)
            map2.put(manufacturers.getManufacturer_id(), manufacturers.getLogo());

        model.addAttribute("map", map);
        model.addAttribute("map2", map2);

        return "admin";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String adminPost(@RequestParam(required = false) MultipartFile upload, @ModelAttribute Products product, Model model){

        if (upload != null && !upload.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + upload.getOriginalFilename();

            try (FileOutputStream fos = new FileOutputStream(uploadPath + resultFilename)){
                byte[] buffer = upload.getBytes();
                fos.write(buffer, 0, buffer.length);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            product.setImage(resultFilename);
        }

        productsService.saveProduct(product);

        model.addAttribute("product", product);
        return "redirect:admin";
    }
}
