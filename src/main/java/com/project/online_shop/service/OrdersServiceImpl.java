package com.project.online_shop.service;

import com.project.online_shop.bl.SessionUtil;
import com.project.online_shop.dao.OrdersDAO;
import com.project.online_shop.entity.Orders;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class OrdersServiceImpl extends SessionUtil implements OrdersDAO {
    @Override
    public void add(Orders orders) {
        openTransactionSession();
        Session session = getSession();
        session.save(orders);
        closeTransactionSesstion();
    }

    @Override
    public List<Orders> getAll() {
        openTransactionSession();

        String sql = "SELECT * FROM orders";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Orders.class);
        List<Orders> orders = query.list();

        closeTransactionSesstion();

        return orders;
    }

    @Override
    public Orders getById(Long id) {
        openTransactionSession();

        String sql = "SELECT * FROM orders WHERE order_id = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Orders.class);
        query.setParameter("id", id);

        Orders orders = (Orders)query.getSingleResult();

        closeTransactionSesstion();

        return orders;
    }

    @Override
    public void update(Orders orders) {
        openTransactionSession();
        Session session = getSession();
        session.update(orders);
        closeTransactionSesstion();
    }

    @Override
    public void remove(Orders orders) {
        openTransactionSession();
        Session session = getSession();
        session.remove(orders);
        closeTransactionSesstion();
    }
}
