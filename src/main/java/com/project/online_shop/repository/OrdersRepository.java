package com.project.online_shop.repository;

import com.project.online_shop.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ordersRepository")
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT MAX(order_id) FROM Orders")
    int getMaxOrderId();
}
