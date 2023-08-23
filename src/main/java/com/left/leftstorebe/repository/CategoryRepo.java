package com.left.leftstorebe.repository;

import com.left.leftstorebe.model.entiti.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    Category findAllById(Integer id);
}
