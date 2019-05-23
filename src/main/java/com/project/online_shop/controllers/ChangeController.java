package com.project.online_shop.controllers;

import com.project.online_shop.domain.Categories;
import com.project.online_shop.domain.Manufacturers;
import com.project.online_shop.domain.Products;
import com.project.online_shop.service.CategoryService;
import com.project.online_shop.service.ManufacturersService;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChangeController {

    private ProductsService productsService;
    private ManufacturersService manufacturersService;
    private CategoryService categoryService;

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
    public String up(@PathVariable("id") Long id, Map<String, Object> map) {
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
}
