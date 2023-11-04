package com.left.leftstorebe.controller;

import com.left.leftstorebe.common.ApiResponse;
import com.left.leftstorebe.model.dto.TypeDTO;
import com.left.leftstorebe.model.entiti.product.Type;
import com.left.leftstorebe.service.TypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/type")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TypeController {
    @Autowired
    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<List<Type>> getTypeList() {
        return new ResponseEntity<>(typeService.getTypeList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type> getType(
            @PathVariable Integer id
    ) {
        return new ResponseEntity<>(typeService.getTypeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addType(
            @RequestBody @Valid TypeDTO typeRequest
    ) {
        typeService.addType(typeRequest);
        return new ResponseEntity<>(new ApiResponse(true, "Add a New Type Successful"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteType(
            @PathVariable Integer id
    ) {
        typeService.deleteType(id);
        return new ResponseEntity<>(new ApiResponse(true, "Category has been DELETE"), HttpStatus.OK);
    }
}
