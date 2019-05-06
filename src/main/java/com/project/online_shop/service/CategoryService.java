package com.project.online_shop.service;

import com.project.online_shop.domain.Category;
import java.util.List;

public interface CategoryService {

    Category getCategoryById(Long id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category);

    List<Category> findAll();
}
