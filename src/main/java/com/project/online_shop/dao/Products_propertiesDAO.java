package com.project.online_shop.dao;

import com.project.online_shop.entity.Products_properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products_propertiesDAO extends JpaRepository<Products_properties, Long> {
}
