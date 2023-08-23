package com.left.leftstorebe.repository;

import com.left.leftstorebe.model.entiti.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findAllById(Integer id);
}
