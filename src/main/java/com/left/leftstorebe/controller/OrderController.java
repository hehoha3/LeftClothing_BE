package com.left.leftstorebe.controller;

import com.left.leftstorebe.common.ApiResponse;
import com.left.leftstorebe.model.entiti.order.Order;
import com.left.leftstorebe.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    @PutMapping("/status/new/{orderId}")
    public ResponseEntity<String> changeToStatusNew(@PathVariable Integer orderId) {
        return new ResponseEntity<>(orderService.changeToStatusNew(orderId), HttpStatus.OK);
    }

    @PutMapping("/status/processing/{orderId}")
    public ResponseEntity<String> changeToStatusProcessing(@PathVariable Integer orderId) {
        return new ResponseEntity<>(orderService.changeToStatusProcessing(orderId), HttpStatus.OK);
    }

    @PutMapping("/status/done/{orderId}")
    public ResponseEntity<String> changeToStatusDone(@PathVariable Integer orderId) {
        return new ResponseEntity<>(orderService.changeToStatusDone(orderId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId) {
        return new ResponseEntity<>(orderService.deleteOrder(orderId), HttpStatus.OK);
    }
}
