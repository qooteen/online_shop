package com.project.online_shop.repository;

import com.project.online_shop.domain.Products_images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("products_imagesRepository")
public interface Products_imagesRepository extends JpaRepository<Products_images, Long> {
}
