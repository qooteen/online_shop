package com.project.online_shop.controllers;

import com.project.online_shop.domain.Item;
import com.project.online_shop.service.ProductsService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cart")
public class CartController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "/cart/cart";
    }

    @RequestMapping(value = {"/buy/{id}"}, method = RequestMethod.GET)
    public String cart(@PathVariable("id") Long id, HttpSession session) {
       if (session.getAttribute("cart") == null) {
            List<Item> cart = new ArrayList<>();
            cart.add(new Item(productsService.getProductById(id), 1));
            session.setAttribute("cart", cart);
        }
       else {
           List<Item> cart = (List<Item>) session.getAttribute("cart");
           int index = isExists(id, cart);
           if (index == -1) {
               cart.add(new Item(productsService.getProductById(id), 1));

           } else {
               int quantity = cart.get(index).getQuantity() + 1;
               cart.get(index).setQuantity(quantity);
           }
           session.setAttribute("cart", cart);

       }

        return "redirect:../../cart";
    }

    @RequestMapping(value = {"/remove/{id}"}, method = RequestMethod.GET)
    public String remove(@PathVariable("id") Long id, HttpSession session) {

        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExists(id, cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        return "redirect:../../cart";
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public String update(HttpServletRequest request, HttpSession session) {

        String[] quantities = request.getParameterValues("quantity");
        List<Item> cart = (List<Item>) session.getAttribute("cart");

        for (int i = 0; i < cart.size(); i++) {
            cart.get(i).setQuantity(Integer.parseInt(quantities[i]));
        }
        session.setAttribute("cart", cart);

        return "redirect:../cart";
    }


    private int isExists(Long id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProducts().getProduct_id() == id)
                return i;
        }
        return -1;
    }
}
