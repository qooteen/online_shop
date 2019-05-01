package com.project.online_shop.dao;

import com.project.online_shop.entity.Products_images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products_imagesDAO extends JpaRepository<Products_images, Long> {
}
