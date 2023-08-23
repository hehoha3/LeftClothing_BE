package com.left.leftstorebe.model.dto;

import com.left.leftstorebe.model.entiti.product.Gender;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ProductDTO {
    private Integer id;

    @NotNull(message = "Product's Name Shouldn't Be Null !!!")
    @NotEmpty(message = "Product's Name Shouldn't Be Empty !!!")
    private String productName;

    @NotNull(message = "Product's Description Shouldn't Be Null !!!")
    @NotEmpty(message = "Product's Description Shouldn't Be Empty !!!")
    private String productDescription;


    @NotNull(message = "Product's Image Shouldn't Be Null !!!")
    @NotEmpty(message = "Product's Image Shouldn't Be Empty !!!")
    private List<String> productImages;

    @NotNull(message = "Product's Price Shouldn't Be NULL")
    private Double productPrice;

    @NotNull(message = "Product's Quantity Shouldn't Be NULL")
    private Integer productQuantity;

    @NotNull(message = "Product's Size Shouldn't Be Null !!!")
    @NotEmpty(message = "Product's Size Shouldn't Be Empty !!!")
    private List<String> productSizes;

    @NotNull(message = "Product's Image Shouldn't Be Null !!!")
    private Integer productCategory;

    @NotNull(message = "Product's Gender Shouldn't Be Null !!!")
    @NotEmpty(message = "Product's Gender Shouldn't Be Empty !!!")
    private List<Gender> productGender;
}
