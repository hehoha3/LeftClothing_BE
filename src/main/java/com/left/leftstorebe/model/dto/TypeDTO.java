package com.left.leftstorebe.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class TypeDTO {
    private Integer id;

    @NotNull(message = "Product's Name Shouldn't Be Null !!!")
    @NotEmpty(message = "Product's Name Shouldn't Be Empty !!!")
    private String name;

    @NotNull(message = "Product's Image Shouldn't Be Null !!!")
    private Integer typeCategory;
}
