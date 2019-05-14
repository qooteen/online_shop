package com.project.online_shop.service;

import com.project.online_shop.repository.CategoryRepository;
import com.project.online_shop.domain.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Categories getCategoryById(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public void saveCategory(Categories categories) {
        categoryRepository.save(categories);
    }

    @Override
    public void updateCategory(Categories categories) {
        categoryRepository.save(categories);
    }

    @Override
    public void deleteCategory(Categories categories) {
        categoryRepository.delete(categories);
    }

    @Override
    public List<Categories> findAll() {
        return categoryRepository.findAll();
    }
}
