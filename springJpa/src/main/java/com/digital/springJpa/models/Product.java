package com.digital.springJpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    @Column(name = "is_active")
    private Boolean isActive;

    public Product(String name, String description, Double price, Boolean isActive) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isActive = isActive;
    }
}
