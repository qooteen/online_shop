package com.project.online_shop.dao;

import com.project.online_shop.entity.Manufacturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturersDAO extends JpaRepository<Manufacturers, Long> {
}
