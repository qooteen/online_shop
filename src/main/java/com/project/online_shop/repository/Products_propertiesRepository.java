package com.project.online_shop.repository;

import com.project.online_shop.domain.Products_properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("products_propertiesRepository")
public interface Products_propertiesRepository extends JpaRepository<Products_properties, Long> {
}
