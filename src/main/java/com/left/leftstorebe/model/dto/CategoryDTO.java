package com.left.leftstorebe.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class CategoryDTO {
    private Integer id;

    @NotNull(message = "Category's Name Shouldn't Be Null !!!")
    @NotEmpty(message = "Category's Name Shouldn't Be Empty !!!")
    private String categoryName;

    @NotNull(message = "Category's Image Shouldn't Be Null !!!")
    @NotEmpty(message = "Category's Image Shouldn't Be Empty !!!")
    private String categoryImage;
}
