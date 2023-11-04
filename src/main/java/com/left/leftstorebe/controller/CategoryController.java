package com.left.leftstorebe.controller;

import com.left.leftstorebe.common.ApiResponse;
import com.left.leftstorebe.model.dto.CategoryDTO;
import com.left.leftstorebe.model.entiti.product.Category;
import com.left.leftstorebe.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategoryList() {
        return new ResponseEntity<>(categoryService.getCategoryList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(
            @PathVariable Integer id
    ) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(
            @RequestBody @Valid  CategoryDTO categoryRequest
            ) {
        categoryService.addCategory(categoryRequest);
        return new ResponseEntity<>(new ApiResponse(true, "Add a New Category Successful"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory (
            @PathVariable Integer id
    ) {
        if (!categoryService.existsById(id)) {
            return new ResponseEntity<>(new ApiResponse(false, "Category does NOT Exists"), HttpStatus.NOT_FOUND);
        }
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(new ApiResponse(true, "Category has been DELETE"), HttpStatus.OK);
    }
}
