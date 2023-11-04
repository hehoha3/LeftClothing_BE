package com.left.leftstorebe.model.entiti.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "collections")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "collection_name")
    private String name;
}
