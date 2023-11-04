package com.left.leftstorebe.service;

import com.left.leftstorebe.model.dto.cart.AddToCartDTO;
import com.left.leftstorebe.model.dto.cart.UpdateCartDTO;
import com.left.leftstorebe.model.entiti.cart.Cart;
import com.left.leftstorebe.model.entiti.order.Order;
import com.left.leftstorebe.model.entiti.order.Status;
import com.left.leftstorebe.model.entiti.product.Product;
import com.left.leftstorebe.model.entiti.user.User;
import com.left.leftstorebe.repository.CartRepo;
import com.left.leftstorebe.repository.OrderRepo;
import com.left.leftstorebe.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    @Autowired
    private final CartRepo cartRepo;

    @Autowired
    private final ProductRepo productRepo;

    @Autowired
    private final ProductService productService;

    @Autowired
    private final UserService userService;

    @Autowired
    private final OrderRepo orderRepo;

    public List<Cart> getCarts(
            String token
    ) {
        User user = userService.getUserByToken(token);
        return cartRepo.findAllByUser(user);
    }

    public String addToCart(
            AddToCartDTO addToCartDTO,
            String token
    ) {
        User user = userService.getUserByToken(token);
        Product product = productService.getProductById(addToCartDTO.getProductId());

        Cart cart = new Cart();

        cart.setProduct(product);
        cart.setSize(addToCartDTO.getSize());
        cart.setQuantity(addToCartDTO.getQuantity());
        cart.setUser(user);
        cart.setCreatedAt(new Date());
        cart.setUpdatedAt(new Date());
        cartRepo.save(cart);

        return "Add To Cart Success";
    }

    public String upCartQuantity(
            UpdateCartDTO updateCartDTO,
            String token
    ) {
        User user = userService.getUserByToken(token);

        List<Cart> userCart = cartRepo.findAllByUser(user);

        for (Cart cart : userCart) {
            if (cart.getProduct().getId().equals(updateCartDTO.getProductId()) && cart.getSize().equals(updateCartDTO.getSize())) {
                if (cart.getQuantity() == productService.getProductById(updateCartDTO.getProductId()).getProductQuantity()) {
                    return "Out of stock";
                } else {
                    cart.setQuantity(cart.getQuantity() + 1);
                    cart.setUpdatedAt(new Date());
                }

                cartRepo.save(cart);
            }
        }

        return "Up Quantity in Cart Success";
    }

    public String downCartQuantity(
            UpdateCartDTO updateCartDTO,
            String token
    ) {
        User user = userService.getUserByToken(token);

        List<Cart> userCart = cartRepo.findAllByUser(user);

        for (Cart cart : userCart) {
            if (cart.getProduct().getId().equals(updateCartDTO.getProductId()) && cart.getSize().equals(updateCartDTO.getSize())) {
                if (cart.getQuantity() == 1) {
                    cartRepo.delete(cart);
                } else {
                    cart.setQuantity(cart.getQuantity() - 1);
                    cart.setUpdatedAt(new Date());

                    cartRepo.save(cart);
                }
            }
        }

        return "Down Quantity in Cart Success";
    }

    @Transactional
    public String deleteCart(
            UpdateCartDTO updateCartDTO,
            String token
    ) {
        User user = userService.getUserByToken(token);

        List<Cart> userCart = cartRepo.findAllByUser(user);

        for (Cart cart : userCart) {
            if (cart.getProduct().getId().equals(updateCartDTO.getProductId()) && cart.getSize().equals(updateCartDTO.getSize())) {
                cartRepo.delete(cart);
            }
        }

        return "Delete Cart Success";
    }

    public String checkout(
            String token
    ) {
        User user = userService.getUserByToken(token);
        List<Cart> userCarts = cartRepo.findAllByUser(user);
        for (Cart cart : userCarts) {
            Product product = cart.getProduct();
            Integer quantity = cart.getQuantity();
            product.setProductQuantity(product.getProductQuantity() - quantity);
            productRepo.save(product);

            Order order = new Order();
            order.setUser(user);
            order.setProduct(product);
            order.setQuantity(cart.getQuantity());
            order.setSize(cart.getSize());
            order.setStatus(Status.NEW);
            order.setCreatedAt(new Date());

            orderRepo.save(order);
        }
        cartRepo.deleteAllByUser(user);

        return "Check Out Success";
    }
}
