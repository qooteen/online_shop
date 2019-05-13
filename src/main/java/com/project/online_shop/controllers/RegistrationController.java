package com.project.online_shop.controllers;

import com.project.online_shop.domain.Products;
import com.project.online_shop.domain.Roles;
import com.project.online_shop.domain.Users;
import com.project.online_shop.service.ProductsService;
import com.project.online_shop.service.RolesService;
import com.project.online_shop.service.UsersService;
import com.project.online_shop.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class RegistrationController {

    private RolesService rolesService;

    private UsersService usersService;

    private ProductsService productsService;

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

        return "admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String adminPost(@ModelAttribute Products product, Model model) {
        productsService.saveProduct(product);
        model.addAttribute("product", product);

        return "admin";
    }
}