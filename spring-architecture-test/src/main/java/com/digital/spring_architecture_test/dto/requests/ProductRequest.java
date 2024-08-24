package com.digital.spring_architecture_test.dto.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @NotNull
    @Size(min = 10, max = 100)
    private String description;

    @NotEmpty
    @NotNull
    @Min(value = 1, message = "Price must be greater than 0")
    private Double price;
}
