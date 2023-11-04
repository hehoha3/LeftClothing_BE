package com.left.leftstorebe.service;

import com.left.leftstorebe.model.dto.TypeDTO;
import com.left.leftstorebe.model.entiti.product.Category;
import com.left.leftstorebe.model.entiti.product.Type;
import com.left.leftstorebe.repository.CategoryRepo;
import com.left.leftstorebe.repository.TypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {
    @Autowired
    private final TypeRepo typeRepo;

    @Autowired
    private final CategoryRepo categoryRepo;

    public List<Type> getTypeList() {
        return typeRepo.findAll();
    }

    public Type getTypeById(Integer id) {
        return typeRepo.findAllById(id);
    }

    public void addType(TypeDTO typeRequest) {
        Type newType = new Type();
        newType.setName(typeRequest.getName());

        Category typeCategory = categoryRepo.findAllById(typeRequest.getTypeCategory());
        newType.setTypeCategory(typeCategory);
        typeRepo.save(newType);
    }

    public void deleteType(Integer id) {
        typeRepo.deleteById(id);
    }
}
