package com.project.online_shop.service;

import com.project.online_shop.domain.Orders;
import com.project.online_shop.domain.Users;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrdersService {

    Orders getOrderById(Long id);

    void saveOrder(Orders orders);

    void updateOrder(Orders orders);

    void deleteOrder(Orders orders);

    List<Orders> findAll();

    @Transactional
    Long getMaxOrderId();

    List<Orders> findAllByUser(Users users);
}
