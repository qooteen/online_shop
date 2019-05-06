package com.project.online_shop.repository;

import com.project.online_shop.domain.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("discountsRepository")
public interface DiscountsRepository extends JpaRepository<Discounts, Long> {
}
