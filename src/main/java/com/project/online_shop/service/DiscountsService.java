package com.project.online_shop.service;

import com.project.online_shop.domain.Discounts;
import java.util.List;

public interface DiscountsService {

    Discounts getDiscountById(Long id);

    void saveDiscount(Discounts discounts);

    void updateDiscount(Discounts discounts);

    void deleteDiscount(Discounts discounts);

    List<Discounts> findAll();
}
