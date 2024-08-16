package com.digital.injectionD.repositories;

import com.digital.injectionD.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Primary
@Repository("productListRepo")
public class ProductRepositoryImp implements ProductRepository {
    private List<Product> data;

    public ProductRepositoryImp() {
        this.data = List.of(
            new Product(1L, "Mouse Pad", 100L),
            new Product(2L, "PC", 200L),
            new Product(3L, "Test Book", 300L),
            new Product(4L, "Phone", 400L)
        );
    }
    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}
