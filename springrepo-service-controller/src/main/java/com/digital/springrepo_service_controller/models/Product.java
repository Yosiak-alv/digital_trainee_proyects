package com.digital.springrepo_service_controller.models;

import com.digital.springrepo_service_controller.validations.IsExistDb;
import com.digital.springrepo_service_controller.validations.IsRequired;
import com.digital.springrepo_service_controller.validations.IsUnique;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @IsRequired
    //@IsExistDb
    //@IsUnique(domainClass = Product.class, fieldName = "sku", message = "the sku must be unique")
    private String sku;

    @IsRequired
    @Size(min = 3, max = 20)
    private String name;

    @Min(value = 500, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Double price;

    @IsRequired
    private String description;
}
