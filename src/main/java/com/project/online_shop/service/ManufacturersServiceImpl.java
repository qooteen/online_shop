package com.project.online_shop.service;

import com.project.online_shop.dao.ManufacturersRepo;
import com.project.online_shop.entity.Manufacturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturersServiceImpl implements ManufacturersService{

    private ManufacturersRepo manufacturersRepo;

    @Autowired
    public void setManufacturersRepo(ManufacturersRepo manufacturersRepo) {
        this.manufacturersRepo = manufacturersRepo;
    }

    @Override
    public Manufacturers getManufacturerById(Long id) {
        return manufacturersRepo.getOne(id);
    }

    @Override
    public void saveManufacturer(Manufacturers manufacturers) {
        manufacturersRepo.save(manufacturers);
    }

    @Override
    public void updateManufacturer(Manufacturers manufacturers) {
        manufacturersRepo.save(manufacturers);
    }

    @Override
    public void deleteManufacturer(Manufacturers manufacturers) {
        manufacturersRepo.delete(manufacturers);
    }

    @Override
    public List<Manufacturers> findAll() {
        return manufacturersRepo.findAll();
    }
}
