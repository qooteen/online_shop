package com.project.online_shop.service;

import com.project.online_shop.domain.Products_buy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Products_buyService {

    Products_buy getProducts_buyById(Long id);

    void saveProducts_buy(Products_buy products_buy);

    void updateProducts_buy(Products_buy products_buy);

    void deleteProducts_buy(Products_buy products_buy);

    List<Products_buy> findAll();

    @Transactional
    Long getMaxProducts_buyId();
}
