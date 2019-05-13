package com.project.online_shop.controllers;

import com.project.online_shop.domain.Category;
import com.project.online_shop.domain.Products;
import com.project.online_shop.service.CategoryService;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {


    private CategoryService categoryService;
    private ProductsService productsService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productsService.findAll());
        return "main";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String mainPagePost(@PathVariable Long id, Model model) {

        Category category = categoryService.getCategoryById(id);

        model.addAttribute("products", category.getProducts());
        model.addAttribute("categories", categoryService.findAll());
        return "main";
    }

}
