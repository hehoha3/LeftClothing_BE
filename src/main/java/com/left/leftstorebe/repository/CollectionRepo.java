package com.left.leftstorebe.repository;

import com.left.leftstorebe.model.entiti.product.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepo extends JpaRepository<Collection, Integer> {
    Collection findAllById(Integer id);
}
