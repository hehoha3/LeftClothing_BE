package com.left.leftstorebe.service;

import com.left.leftstorebe.model.entiti.product.Collection;
import com.left.leftstorebe.repository.CollectionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionService {
    @Autowired
    private final CollectionRepo collectionRepo;

    public List<Collection> getCollectionList() {
        return collectionRepo.findAll();
    }

    public Collection getCollectionById(Integer id) {
        return collectionRepo.findAllById(id);
    }

    public void addCollection(Collection collectionRequest) {
        collectionRepo.save(collectionRequest);
    }

    public void deleteCollection(Integer id) {
        collectionRepo.deleteById(id);
    }
}
