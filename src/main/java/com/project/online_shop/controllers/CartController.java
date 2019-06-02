package com.project.online_shop.controllers;

import com.project.online_shop.domain.*;
import com.project.online_shop.service.*;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

@Controller
@RequestMapping("cart")
public class CartController {

    private ProductsService productsService;

    private Products_buyService products_buyService;

    private UsersService usersService;

    private OrdersService ordersService;

    @Autowired
    public void setProducts_buyService(Products_buyService products_buyService) {
        this.products_buyService = products_buyService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        model.addAttribute("total", summ(session));

        return "/cart/cart";
    }

    @RequestMapping(value = {"/buy/{id}"}, method = RequestMethod.GET)
    public String buy(@PathVariable("id") Long id, HttpSession session) {
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

    private Map<Long, String[]> map = new HashMap<>();


    @RequestMapping(value = {"/remove/{id}"}, method = RequestMethod.GET)
    public String remove(@PathVariable("id") Long id, HttpSession session) {

        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int index = isExists(id, cart);
        cart.remove(index);
        map.remove(id);
        session.setAttribute("cart", cart);
        return "redirect:../../cart";
    }

    @RequestMapping(value = {"/update/{id}"}, method = RequestMethod.POST)
    public String update(@PathVariable("id") Long id, HttpServletRequest request, HttpSession session) {
        if (map.containsKey(id))
            map.remove(id);
        map.put(id, request.getParameterValues("quantity"));
        List<Item> cart = (List<Item>) session.getAttribute("cart");

        for (int i = 0; i < cart.size(); i++)
        for (Map.Entry<Long, String[]> pair: map.entrySet()) {
            if (pair.getKey() == id && cart.get(i).getProducts().getProduct_id() == id) {
                cart.get(i).setQuantity(Integer.parseInt(pair.getValue()[0]));
                break;
            }
        }

        session.setAttribute("cart", cart);

        return "redirect:../../cart";
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public String order(HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");

        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser"))
            return "login";

        UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Orders orders = new Orders();

        orders.setOrder_id(ordersService.getMaxOrderId() + 1);
        orders.setOrder_date(new Date());
        orders.setOrder_time(LocalTime.now());

        if (cart != null && !cart.isEmpty()) {
            for (Item item : cart) {
                Products_buy products_buy = new Products_buy();
                products_buy.setBuy_id(products_buyService.getMaxProducts_buyId() + 1);
                products_buy.setProduct_id(item.getProducts());
                products_buy.setOrder_id(orders);
                products_buy.setQuantity(item.getQuantity());
                products_buyService.saveProducts_buy(products_buy);
            }


            orders.setUser(usersService.findByUsername(userDetail.getUsername()));
            ordersService.saveOrder(orders);

            for (Item item : cart) {
                Products tmp = productsService.getProductById(item.getProducts().getProduct_id());
                tmp.setQuantity(tmp.getQuantity() - item.getQuantity());
                productsService.updateProduct(tmp);
            }

            session.setAttribute("cart", null);
        }
        return "redirect:/cart";
    }

    private int isExists(Long id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProducts().getProduct_id() == id)
                return i;
        }
        return -1;
    }

    private int summ(HttpSession session) {
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        int summ = 0;
        if (cart != null && cart.size() != 0)
        for (Item item: cart) {
            summ += item.getQuantity() * item.getProducts().getPrice().intValue();
        }
        return summ;
    }
}
