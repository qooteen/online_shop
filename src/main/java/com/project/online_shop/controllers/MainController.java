package com.project.online_shop.controllers;

import com.project.online_shop.domain.Categories;
import com.project.online_shop.domain.Item;
import com.project.online_shop.domain.Products;
import com.project.online_shop.service.CategoryService;
import com.project.online_shop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Value("${upload.path}")
    private String uploadPath;

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

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("products", productsService.findAll());
        return "main";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String mainPagePost(@PathVariable Long id, Model model) {

        Categories categories = categoryService.getCategoryById(id);

        model.addAttribute("products", categories.getProducts());
        model.addAttribute("categories", categoryService.findAll());
        return "main";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String mainDelete(@PathVariable Long id, HttpSession session) {
        Products products = productsService.getProductById(id);

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        File[] files = uploadDir.listFiles();
        if (files != null && files.length != 0)
            for (File file : files)
                if (file.getName().equals(products.getImage())) {
                    file.delete();
                    break;
                }

        productsService.deleteProduct(products);
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if (cart != null) {
            int index = isExists(id, cart);
            if (index != -1)
            cart.remove(index);
        }
        return "redirect:/";
    }

    private int isExists(Long id, List<Item> cart) {
        if (cart != null)
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getProducts().getProduct_id() == id)
                    return i;
            }
        return -1;
    }
}
