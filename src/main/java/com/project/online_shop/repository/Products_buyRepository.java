package com.project.online_shop.repository;

import com.project.online_shop.domain.Products_buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("products_buyRepository")
public interface Products_buyRepository extends JpaRepository<Products_buy, Long> {
    @Transactional
    @Query("SELECT MAX(buy_id) FROM Products_buy")
    Long getMaxProducts_buyId();
}
