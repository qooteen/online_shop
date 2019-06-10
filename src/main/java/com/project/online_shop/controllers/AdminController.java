package com.project.online_shop.controllers;

import com.project.online_shop.domain.Categories;
import com.project.online_shop.domain.Manufacturers;
import com.project.online_shop.domain.Products;
import com.project.online_shop.service.CategoryService;
import com.project.online_shop.service.ManufacturersService;
import com.project.online_shop.service.ProductsService;
import com.project.online_shop.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Value("${upload.path}")
    private String uploadPath;

    private ProductValidator productValidator;

    @Autowired
    public void setProductValidator(ProductValidator productValidator) {
        this.productValidator = productValidator;
    }

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

    @RequestMapping(method = RequestMethod.GET)
    public String editPage(Model model) {
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
    public String editImage(@RequestParam MultipartFile upload, @ModelAttribute("product") @Validated Products product, Model model, BindingResult bindingResult){

        productValidator.validate(product, bindingResult);

        Map<Categories, String> map = new HashMap<>();

        List<Categories> categoriesList = categoryService.findAll();
        for (Categories categories : categoriesList)
            map.put(categories, categories.getLogo());

        Map<Long, String> map2 = new HashMap<>();

        List<Manufacturers> manufacturersList = manufacturersService.findAll();
        for (Manufacturers manufacturers : manufacturersList)
            map2.put(manufacturers.getManufacturer_id(), manufacturers.getLogo());

        if (bindingResult.hasErrors()) {
            model.addAttribute("map", map);
            model.addAttribute("map2", map2);
            return "admin";
        }

        productsService.uploadImage(upload, uploadPath, product);
        model.addAttribute("product", product);
        return "redirect:admin";
    }
}
