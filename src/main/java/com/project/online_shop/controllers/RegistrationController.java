package com.project.online_shop.controllers;

import com.project.online_shop.domain.Categories;
import com.project.online_shop.domain.Manufacturers;
import com.project.online_shop.domain.Products;
import com.project.online_shop.domain.Users;
import com.project.online_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Controller
public class RegistrationController {

    private RolesService rolesService;

    private UsersService usersService;

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

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Value("${upload.path}")
    private String uploadPath;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Users());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute Users userForm, Model model) {
        Users users = usersService.findByUsername(userForm.getUsername());
        if (users == null) {
            usersService.saveUser(userForm);
            return "redirect:/login";
        }
        model.addAttribute("error", "Already exists");
        model.addAttribute("userForm", userForm);

        return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
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

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
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