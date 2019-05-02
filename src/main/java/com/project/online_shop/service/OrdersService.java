package com.project.online_shop.service;

import com.project.online_shop.entity.Orders;
import java.util.List;

public interface OrdersService {

    Orders getOrderById(Long id);

    void saveOrder(Orders orders);

    void updateOrder(Orders orders);

    void deleteOrder(Orders orders);

    List<Orders> findAll();
}
