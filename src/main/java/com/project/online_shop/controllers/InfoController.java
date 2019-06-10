package com.project.online_shop.controllers;

import com.project.online_shop.domain.*;
import com.project.online_shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class InfoController {

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
        List<Categories> categoriesList = categoryService.findAll();
        List<Manufacturers> manufacturersList = manufacturersService.findAll();
        map.put("categories", categoriesList);
        map.put("manufacturers", manufacturersList);
        return "update";
    }

    @RequestMapping(value = {"/info"})
    public String infoPage(Model model) {
        UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = usersService.findByUsername(userDetail.getUsername());
        Collection<? extends GrantedAuthority> authorities
                = userDetail.getAuthorities();
        for (GrantedAuthority authority: authorities)
        if (authority.getAuthority().equals("ROLE_ADMIN")) {
            model.addAttribute("orders", ordersService.findAll());
            return "history";
        }

        List<Orders> orders = ordersService.findAllByUser(user);
        model.addAttribute("orders", orders);
        return "history";
    }

    @RequestMapping(value="/view/{id}", produces = {
            MediaType.TEXT_HTML_VALUE},
            method = RequestMethod.GET)
    public String viewContacts (@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        return "show";
    }
}
