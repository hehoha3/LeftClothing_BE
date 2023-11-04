package com.left.leftstorebe.service;

import com.left.leftstorebe.model.entiti.order.Order;
import com.left.leftstorebe.model.entiti.order.Status;
import com.left.leftstorebe.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    @Autowired
    private final OrderRepo orderRepo;

    public List<Order> getAllOrder(
    ) {
        return orderRepo.findAll();
    }

    public String changeToStatusNew(Integer orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(Status.NEW);
        orderRepo.save(order);
        return "Change Order Success";
    }

    public String changeToStatusProcessing(Integer orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(Status.PROCESSING);
        orderRepo.save(order);
        return "Change Order Success";
    }

    public String changeToStatusDone(Integer orderId) {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(Status.DONE);
        orderRepo.save(order);
        return "Change Order Success";
    }

    public String deleteOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Delete Order Success";
    }
}
