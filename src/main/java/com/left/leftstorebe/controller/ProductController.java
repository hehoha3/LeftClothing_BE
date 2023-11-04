package com.left.leftstorebe.controller;

import com.left.leftstorebe.common.ApiResponse;
import com.left.leftstorebe.model.dto.ProductDTO;
import com.left.leftstorebe.model.entiti.product.Product;
import com.left.leftstorebe.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProductList() {
        return new ResponseEntity<>(productService.getProductList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable Integer id
    ) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(
            @RequestBody @Valid ProductDTO productRequest
    ) {
        productService.addProduct(productRequest);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateProduct(
            @PathVariable Integer id,
            @RequestBody @Valid ProductDTO productRequest
    ) {
        if (!productService.existsById(id)) {
            return new ResponseEntity<>(new ApiResponse(false, "Product does not exists"), HttpStatus.NOT_FOUND);
        }
        productService.updateProduct(id, productRequest);
        return new ResponseEntity<>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable Integer id
    ) {
        if (!productService.existsById(id)) {
            return new ResponseEntity<>(new ApiResponse(false, "Product does not exists"), HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        return new ResponseEntity<>(new ApiResponse(true, "Category has been DELETE"), HttpStatus.OK);
    }
}
