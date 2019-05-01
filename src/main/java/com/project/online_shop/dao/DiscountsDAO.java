package com.project.online_shop.dao;

import com.project.online_shop.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountsDAO extends JpaRepository<Discounts, Long> {
}
