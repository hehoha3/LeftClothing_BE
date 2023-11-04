package com.left.leftstorebe.model.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class AddToCartDTO {
    private Integer id;

    @NotNull(message = "Product's Quantity Shouldn't Be NULL")
    private Integer productId;

    @NotNull(message = "Product's Quantity Shouldn't Be NULL")
    private String size;

    @NotNull(message = "Product's Quantity Shouldn't Be NULL")
    private Integer quantity;
}
