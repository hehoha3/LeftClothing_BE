package com.left.leftstorebe.repository;

import com.left.leftstorebe.model.entiti.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
}
