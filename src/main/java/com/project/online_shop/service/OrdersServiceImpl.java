package com.project.online_shop.service;

import com.project.online_shop.repository.OrdersRepository;
import com.project.online_shop.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService{

    private OrdersRepository ordersRepository;

    @Autowired
    public void setOrdersRepository(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public Orders getOrderById(Long id) {
        return ordersRepository.getOne(id);
    }

    @Override
    public void saveOrder(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void updateOrder(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void deleteOrder(Orders orders) {
        ordersRepository.delete(orders);
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public int getMaxOrderId() {
        return ordersRepository.getMaxOrderId();
    }

}
