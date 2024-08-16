package com.digital.injectionD.repositories;

import com.digital.injectionD.models.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
