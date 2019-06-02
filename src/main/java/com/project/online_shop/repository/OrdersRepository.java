package com.project.online_shop.repository;

import com.project.online_shop.domain.Orders;
import com.project.online_shop.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository("ordersRepository")
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Transactional
    @Query("SELECT MAX(order_id) FROM Orders")
    Long getMaxOrderId();

    List<Orders> findAllByUser(Users users);
}
