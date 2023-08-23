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

    public Category addCategory(@NotNull CategoryDTO categoryRequest) {
        Category newCategory = Category.build(
                0,
                categoryRequest.getCategoryName(),
                categoryRequest.getCategoryImage()
        );
        return categoryRepo.save(newCategory);
    }

    public String deleteCategory(Integer id) {
        if (categoryRepo.existsById(id)) {
            categoryRepo.deleteById(id);
            return "DELETE CATEGORY SUCCESSFULLY !";
        } else {
            return "THIS CATEGORY'S ID DOES NOT EXIST !!";
        }
    }
}
