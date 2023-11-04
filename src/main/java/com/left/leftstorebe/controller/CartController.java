package com.left.leftstorebe.controller;

import com.left.leftstorebe.model.dto.cart.AddToCartDTO;
import com.left.leftstorebe.model.dto.cart.UpdateCartDTO;
import com.left.leftstorebe.model.entiti.cart.Cart;
import com.left.leftstorebe.model.entiti.user.User;
import com.left.leftstorebe.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    @Autowired
    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getListCart(
            @RequestParam("token") String token
    ) {
        return new ResponseEntity<>(cartService.getCarts(token), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addToCart(
            @RequestBody @Valid AddToCartDTO addToCartDTO,
            @RequestParam("token") String token
    ){
        return new ResponseEntity<>(cartService.addToCart(addToCartDTO, token), HttpStatus.OK);
    }

    @PutMapping("/up")
    public ResponseEntity<String> upCartQuantity(
            @RequestBody @Valid UpdateCartDTO updateCartDTO,
            @RequestParam("token") String token
    ){
        return new ResponseEntity<>(cartService.upCartQuantity(updateCartDTO, token), HttpStatus.OK);
    }

    @PutMapping("/down")
    public ResponseEntity<String> downCartQuantity(
            @RequestBody @Valid UpdateCartDTO updateCartDTO,
            @RequestParam("token") String token
    ){
        return new ResponseEntity<>(cartService.downCartQuantity(updateCartDTO, token), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCart(
            @RequestBody @Valid UpdateCartDTO updateCartDTO,
            @RequestParam("token") String token
    ){
        return new ResponseEntity<>(cartService.deleteCart(updateCartDTO, token), HttpStatus.OK);
    }

    @DeleteMapping("/checkout")
    public ResponseEntity<String> checkout(
            @RequestParam("token") String token
    ){
        return new ResponseEntity<>(cartService.checkout(token), HttpStatus.OK);
    }
}
