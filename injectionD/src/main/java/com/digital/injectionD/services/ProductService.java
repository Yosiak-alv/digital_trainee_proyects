package com.digital.injectionD.services;

import com.digital.injectionD.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
}
