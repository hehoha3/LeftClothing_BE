package com.left.leftstorebe.model.entiti.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pTypes")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category typeCategory;
}
