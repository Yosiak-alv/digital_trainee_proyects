package com.digital.spring_architecture_test.dto;

import com.digital.spring_architecture_test.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double unitPrice;

    public ProductDto(Product product){
        BeanUtils.copyProperties(product, this);
    }

    public Product toEntity(){
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }
}
