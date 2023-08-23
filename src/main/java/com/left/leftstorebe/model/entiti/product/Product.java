package com.left.leftstorebe.model.entiti.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            allocationSize = 1,
            sequenceName = "product_sequence"
    )
    @GeneratedValue(
            generator = "product_sequence",
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(name = "pName")
    private String productName;

    @Column(name = "pDesc")
    private String productDescription;

    @Column(name = "pImages")
    private List<String> productImages;

    @Column(name = "pPrice")
    private Double productPrice;

    @Column(name = "pQuantity")
    private Integer productQuantity;

    @Column(name = "pSize")
    private List<String> productSizes;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category productCategory;

    @Column(name = "pGender")
    @Enumerated(EnumType.STRING)
    private List<Gender> productGender;

}
