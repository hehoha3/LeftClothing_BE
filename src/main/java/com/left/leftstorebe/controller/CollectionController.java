package com.left.leftstorebe.controller;

import com.left.leftstorebe.common.ApiResponse;
import com.left.leftstorebe.model.entiti.product.Collection;
import com.left.leftstorebe.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/collection")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class CollectionController {
    @Autowired
    private final CollectionService collectionService;

    @GetMapping
    public ResponseEntity<List<Collection>> getCollectionList() {
        return new ResponseEntity<>(collectionService.getCollectionList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collection> getCollection(
            @PathVariable Integer id
    ) {
        return new ResponseEntity<>(collectionService.getCollectionById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addCollection(
            @RequestBody Collection collectionRequest
    ) {
        collectionService.addCollection(collectionRequest);
        return new ResponseEntity<>(new ApiResponse(true, "Add a New Collection Successful"), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCollection(
            @PathVariable Integer id
    ) {
        collectionService.deleteCollection(id);
        return new ResponseEntity<>(new ApiResponse(true, "Collection has been DELETE"), HttpStatus.OK);
    }
}
