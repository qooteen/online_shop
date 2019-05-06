package com.project.online_shop.repository;

import com.project.online_shop.domain.Manufacturers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("manufacturersRepository")
public interface ManufacturersRepository extends JpaRepository<Manufacturers, Long> {
}
