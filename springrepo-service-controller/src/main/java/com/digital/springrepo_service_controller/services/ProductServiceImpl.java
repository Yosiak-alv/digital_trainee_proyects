package com.digital.springrepo_service_controller.services;

import com.digital.springrepo_service_controller.models.Product;
import com.digital.springrepo_service_controller.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product productToUpdate = optionalProduct.get();
            productToUpdate.setName(product.getName());
            productToUpdate.setSku(product.getSku());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            return Optional.of(repository.save(productToUpdate));
        }
        return optionalProduct;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        optionalProduct.ifPresent(product -> {
            repository.delete(product);
        });
        return optionalProduct;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsBySku(String sku) {
        return repository.existsBySku(sku);
    }
}
