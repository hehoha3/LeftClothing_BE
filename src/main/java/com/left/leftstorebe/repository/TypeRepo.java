package com.left.leftstorebe.repository;

import com.left.leftstorebe.model.entiti.product.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type, Integer> {
    Type findAllById(Integer id);
}
