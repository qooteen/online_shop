package com.project.online_shop.service;

import com.project.online_shop.dao.OrdersRepo;
import com.project.online_shop.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService{

    private OrdersRepo ordersRepo;

    @Autowired
    public void setOrdersRepo(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    @Override
    public Orders getOrderById(Long id) {
        return ordersRepo.getOne(id);
    }

    @Override
    public void saveOrder(Orders orders) {
        ordersRepo.save(orders);
    }

    @Override
    public void updateOrder(Orders orders) {
        ordersRepo.save(orders);
    }

    @Override
    public void deleteOrder(Orders orders) {
        ordersRepo.delete(orders);
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepo.findAll();
    }
}
