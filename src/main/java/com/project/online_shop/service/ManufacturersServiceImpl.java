package com.project.online_shop.service;

import com.project.online_shop.repository.ManufacturersRepository;
import com.project.online_shop.domain.Manufacturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("manufacturersService")
public class ManufacturersServiceImpl implements ManufacturersService{

    private ManufacturersRepository manufacturersRepository;

    @Autowired
    public void setManufacturersRepository(ManufacturersRepository manufacturersRepository) {
        this.manufacturersRepository = manufacturersRepository;
    }

    @Override
    public Manufacturers getManufacturerById(Long id) {
        return manufacturersRepository.getOne(id);
    }

    @Override
    public void saveManufacturer(Manufacturers manufacturers) {
        manufacturersRepository.save(manufacturers);
    }

    @Override
    public void updateManufacturer(Manufacturers manufacturers) {
        manufacturersRepository.save(manufacturers);
    }

    @Override
    public void deleteManufacturer(Manufacturers manufacturers) {
        manufacturersRepository.delete(manufacturers);
    }

    @Override
    public List<Manufacturers> findAll() {
        return manufacturersRepository.findAll();
    }
}
