package com.digital.injectionD.repositories;

import com.digital.injectionD.models.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("productFooRepo")
public class ProductRepositoryFoo implements ProductRepository {
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Foo product", 100L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Foo product", 100L);
    }
}
