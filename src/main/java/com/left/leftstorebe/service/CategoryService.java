package com.left.leftstorebe.service;

import com.left.leftstorebe.model.dto.CategoryDTO;
import com.left.leftstorebe.model.entiti.product.Category;
import com.left.leftstorebe.repository.CategoryRepo;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    @Autowired
    private final CategoryRepo categoryRepo;

    public List<Category> getCategoryList() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepo.findAllById(id);
    }

    public void addCategory(CategoryDTO categoryRequest) {
        Category newCategory = Category.build(
                0,
                categoryRequest.getCategoryName(),
                categoryRequest.getCategoryImage()
        );
        categoryRepo.save(newCategory);
    }

    public void updateCategory(Integer id, CategoryDTO categoryRequest) {
        Category category = categoryRepo.findAllById(id);
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setCategoryImage(categoryRequest.getCategoryImage());
        categoryRepo.save(category);
    }

    public void deleteCategory(Integer id) {
        categoryRepo.deleteById(id);
    }

    public Boolean existsById(Integer id) {
        return categoryRepo.existsById(id);
    }
}
