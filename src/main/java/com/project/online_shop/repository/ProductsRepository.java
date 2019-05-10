package com.project.online_shop.repository;

import com.project.online_shop.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("productsRepository")
public interface ProductsRepository extends JpaRepository<Products, Long> {

    List<Products> findByDescription(String description);
}
