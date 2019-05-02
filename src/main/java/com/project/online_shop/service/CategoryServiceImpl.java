package com.project.online_shop.service;

import com.project.online_shop.dao.CategoryRepo;
import com.project.online_shop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepo categoryRepo;

    @Autowired
    public void setCategoryRepo(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.getOne(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepo.save(category);

    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepo.delete(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
