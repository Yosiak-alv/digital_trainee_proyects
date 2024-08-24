package com.digital.spring_architecture_test.services;

import com.digital.spring_architecture_test.dto.ClientDto;
import com.digital.spring_architecture_test.dto.ProductDto;
import com.digital.spring_architecture_test.dto.requests.ClientRequest;
import com.digital.spring_architecture_test.dto.requests.ProductRequest;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto create(ProductRequest productRequest);
    ProductDto update(Long id, ProductRequest productRequest);
    void deleteById(Long id);
}
