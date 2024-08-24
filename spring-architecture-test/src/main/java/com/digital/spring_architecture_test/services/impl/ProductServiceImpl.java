package com.digital.spring_architecture_test.services.impl;


import com.digital.spring_architecture_test.dto.ClientDto;
import com.digital.spring_architecture_test.dto.ProductDto;
import com.digital.spring_architecture_test.dto.requests.ProductRequest;
import com.digital.spring_architecture_test.exceptions.ResourceNotFoundException;
import com.digital.spring_architecture_test.models.Client;
import com.digital.spring_architecture_test.models.Product;
import com.digital.spring_architecture_test.repositories.ProductRepository;
import com.digital.spring_architecture_test.services.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductDto> findAll() {
        return this.repository.findAll().stream().map(ProductDto::new).toList();
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return new ProductDto(product);
    }

    @Override
    public ProductDto create(ProductRequest productRequest) {
        Product newProduct = new Product();
        newProduct.setName(productRequest.getName());
        newProduct.setDescription(productRequest.getDescription());
        newProduct.setUnitPrice(productRequest.getPrice());
        return new ProductDto(this.repository.save(newProduct));
    }

    @Override
    public ProductDto update(Long id, ProductRequest productRequest) {
        ProductDto productDto = this.findById(id);
        Product product = productDto.toEntity();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setUnitPrice(productRequest.getPrice());
        return new ProductDto(this.repository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        ProductDto productDto = this.findById(id);
        this.repository.deleteById(productDto.getId());
    }
}
