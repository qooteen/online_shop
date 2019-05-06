package com.project.online_shop.service;

import com.project.online_shop.repository.DiscountsRepository;
import com.project.online_shop.domain.Discounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("discountsService")
public class DiscountsServiceImpl implements DiscountsService{

    @Autowired
    private DiscountsRepository discountsRepository;

    @Override
    public Discounts getDiscountById(Long id) {
        return discountsRepository.getOne(id);
    }

    @Override
    public void saveDiscount(Discounts discounts) {
        discountsRepository.save(discounts);
    }

    @Override
    public void updateDiscount(Discounts discounts) {
        discountsRepository.save(discounts);
    }

    @Override
    public void deleteDiscount(Discounts discounts) {
        discountsRepository.delete(discounts);
    }

    @Override
    public List<Discounts> findAll() {
        return discountsRepository.findAll();
    }
}
