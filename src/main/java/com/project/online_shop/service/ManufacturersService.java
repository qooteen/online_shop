package com.project.online_shop.service;

import com.project.online_shop.domain.Manufacturers;
import java.util.List;

public interface ManufacturersService {

    Manufacturers getManufacturerById(Long id);

    void saveManufacturer(Manufacturers manufacturers);

    void updateManufacturer(Manufacturers manufacturers);

    void deleteManufacturer(Manufacturers manufacturers);

    List<Manufacturers> findAll();
}
