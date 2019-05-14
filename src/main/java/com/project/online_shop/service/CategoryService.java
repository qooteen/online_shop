package com.project.online_shop.service;

import com.project.online_shop.domain.Categories;

import java.util.List;

public interface CategoryService {

    Categories getCategoryById(Long id);

    void saveCategory(Categories categories);

    void updateCategory(Categories categories);

    void deleteCategory(Categories categories);

    List<Categories> findAll();
}
