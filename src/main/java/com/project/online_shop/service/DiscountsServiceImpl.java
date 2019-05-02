package com.project.online_shop.service;

import com.project.online_shop.dao.DiscountsRepo;
import com.project.online_shop.entity.Discounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiscountsServiceImpl implements DiscountsService{

    private DiscountsRepo discountsRepo;

    @Autowired
    public void setDiscountsRepo(DiscountsRepo discountsRepo) {
        this.discountsRepo = discountsRepo;
    }

    @Override
    public Discounts getDiscountById(Long id) {
        return discountsRepo.getOne(id);
    }

    @Override
    public void saveDiscount(Discounts discounts) {
        discountsRepo.save(discounts);
    }

    @Override
    public void updateDiscount(Discounts discounts) {
        discountsRepo.save(discounts);
    }

    @Override
    public void deleteDiscount(Discounts discounts) {
        discountsRepo.delete(discounts);
    }

    @Override
    public List<Discounts> findAll() {
        return discountsRepo.findAll();
    }
}
