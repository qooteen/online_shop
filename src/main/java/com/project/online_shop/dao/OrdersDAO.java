package com.project.online_shop.dao;

import com.project.online_shop.entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDAO {
    void add(Orders users) throws SQLException;

    List<Orders> getAll() throws SQLException;

    Orders getById(Long id) throws SQLException;

    void update(Orders users) throws SQLException;

    void remove(Orders users) throws SQLException;
}
