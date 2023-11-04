package com.left.leftstorebe.model.entiti.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @Column(name = "pDesc", length = 500)
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

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type productType;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection productCollection;

    @Column(name = "pGender")
    @Enumerated(EnumType.STRING)
    private List<Gender> productGender;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

}
