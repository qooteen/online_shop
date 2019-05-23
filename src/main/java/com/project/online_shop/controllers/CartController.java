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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cart")
public class CartController {

    private ProductsService productsService;

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
