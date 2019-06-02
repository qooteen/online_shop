package com.project.online_shop.service;

import com.project.online_shop.domain.Products_buy;
import com.project.online_shop.repository.Products_buyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("products_buyService")
public class Products_buyServiceImpl implements Products_buyService {

    private Products_buyRepository products_buyRepository;

    @Autowired
    public void setProducts_buyRepository(Products_buyRepository products_buyRepository) {
        this.products_buyRepository = products_buyRepository;
    }

    @Override
    public Products_buy getProducts_buyById(Long id) {
        return products_buyRepository.getOne(id);
    }

    @Override
    public void saveProducts_buy(Products_buy products_buy) {
        products_buyRepository.save(products_buy);
    }

    @Override
    public void updateProducts_buy(Products_buy products_buy) {
        products_buyRepository.save(products_buy);
    }

    @Override
    public void deleteProducts_buy(Products_buy products_buy) {
        products_buyRepository.delete(products_buy);
    }

    @Override
    public List<Products_buy> findAll() {
        return products_buyRepository.findAll();
    }

    @Transactional
    @Override
    public Long getMaxProducts_buyId() {
        return products_buyRepository.getMaxProducts_buyId() == null ? 0 : products_buyRepository.getMaxProducts_buyId();
    }
}
