package com.project.online_shop.controllers;

import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping(value = "/hello")
    public String products(Model model) {
        model.addAttribute("products", productsService.getProductById(2L));
         return "hello";
    }

}