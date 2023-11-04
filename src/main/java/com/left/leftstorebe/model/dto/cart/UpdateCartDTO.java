package com.left.leftstorebe.model.dto.cart;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UpdateCartDTO {
    private Integer id;

    @NotNull(message = "Product Id Shouldn't Be NULL")
    private Integer productId;

    @NotNull(message = "Product's size Shouldn't Be NULL")
    private String size;
}
