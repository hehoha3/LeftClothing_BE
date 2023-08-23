package com.left.leftstorebe.service;

import com.left.leftstorebe.model.dto.ProductDTO;
import com.left.leftstorebe.model.entiti.product.Category;
import com.left.leftstorebe.model.entiti.product.Product;
import com.left.leftstorebe.repository.CategoryRepo;
import com.left.leftstorebe.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepo productRepo;

    @Autowired
    private final CategoryRepo categoryRepo;

    public List<Product> getProductList() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepo.findAllById(id);
    }

    public Product addProduct(ProductDTO productRequest) {
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
        return productRepo.save(newProduct);
    }

    public String updateProduct(
            Integer id,
            ProductDTO productRequest
    ) {
        if (productRepo.existsById(id)) {
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

            productRepo.saveAndFlush(newProduct);
            return "UPDATE PRODUCT SUCCESSFULLY !";
        } else {
            return "PRODUCT'S ID DOES NOT EXIST !";
        }
    }

    public String deleteProduct(Integer id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return "DELETE PRODUCT SUCCESSFULLY !";
        } else {
            return "THIS PRODUCT'S ID DOES NOT EXIST !!";
        }
    }
}
