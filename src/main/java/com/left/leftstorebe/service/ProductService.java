package com.left.leftstorebe.service;

import com.left.leftstorebe.model.dto.ProductDTO;
import com.left.leftstorebe.model.entiti.product.Category;
import com.left.leftstorebe.model.entiti.product.Collection;
import com.left.leftstorebe.model.entiti.product.Product;
import com.left.leftstorebe.model.entiti.product.Type;
import com.left.leftstorebe.repository.CategoryRepo;
import com.left.leftstorebe.repository.CollectionRepo;
import com.left.leftstorebe.repository.ProductRepo;
import com.left.leftstorebe.repository.TypeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepo productRepo;

    @Autowired
    private final CategoryRepo categoryRepo;

    @Autowired
    private final TypeRepo typeRepo;

    @Autowired
    private final CollectionRepo collectionRepo;

    public List<Product> getProductList() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepo.findAllById(id);
    }

    public void addProduct(ProductDTO productRequest) {
        Product newProduct = new Product();
        newProduct.setProductName(productRequest.getProductName());
        newProduct.setProductDescription(productRequest.getProductDescription());
        newProduct.setProductImages(productRequest.getProductImages());
        newProduct.setProductPrice(productRequest.getProductPrice());
        newProduct.setProductQuantity(productRequest.getProductQuantity());
        newProduct.setProductSizes(productRequest.getProductSizes());
        newProduct.setProductGender(productRequest.getProductGender());

        Category productCategory = categoryRepo.findAllById(productRequest.getProductCategory());
        newProduct.setProductCategory(productCategory);

        Type productType = typeRepo.findAllById(productRequest.getProductType());
        newProduct.setProductType(productType);

        Collection productCollection = collectionRepo.findAllById(productRequest.getProductCollection());
        newProduct.setProductCollection(productCollection);
        newProduct.setCreatedAt(new Date());
        newProduct.setUpdatedAt(new Date());

        productRepo.save(newProduct);
    }

    public void updateProduct(
            Integer id,
            ProductDTO productRequest
    ) {
        Product newProduct = productRepo.findAllById(id);

        newProduct.setProductName(productRequest.getProductName());
        newProduct.setProductDescription(productRequest.getProductDescription());
        newProduct.setProductImages(productRequest.getProductImages());
        newProduct.setProductPrice(productRequest.getProductPrice());
        newProduct.setProductQuantity(productRequest.getProductQuantity());
        newProduct.setProductSizes(productRequest.getProductSizes());
        newProduct.setProductGender(productRequest.getProductGender());

        Category productCategory = categoryRepo.findAllById(productRequest.getProductCategory());

        newProduct.setProductCategory(productCategory);
        newProduct.setUpdatedAt(new Date());

        productRepo.save(newProduct);
    }

    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    public Boolean existsById(Integer id) {
        return productRepo.existsById(id);
    }
}
