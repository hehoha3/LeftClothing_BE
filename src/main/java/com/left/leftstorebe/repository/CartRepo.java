package com.left.leftstorebe.repository;

import com.left.leftstorebe.model.entiti.cart.Cart;
import com.left.leftstorebe.model.entiti.user.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {


    List<Cart> findAllByUser(User user);

    @Modifying
    @Transactional
    void deleteAllByUser(User user);

}
