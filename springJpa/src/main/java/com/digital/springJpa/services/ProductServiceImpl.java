package com.digital.springJpa.services;

import com.digital.springJpa.models.Product;
import com.digital.springJpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;


    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsBySku(String sku) {
        return false;
    }
}

/*
public List<Product> findActiveProducts(Boolean isActive){
    return repository.findActiveProducts(isActive);
}

public List<Product> findByNameAndIsActive(String name, Boolean isActive){
    return repository.findByNameAndIsActive(name, isActive);
}

public Product findById(Long id){
    return repository.findById(id).orElse(null);
}
public List<Product> findByNameLike(String name){
    return repository.findByNameLike(name);
}

public Product findByName(String name){
    return repository.findByName(name).orElse(null);
}

public Product create(Product product){
    //TODO: VALIDATIONS IN A SPECIAL DTO CLASS
    return repository.save(product);
}

public Product update(Product product) {
    //TODO: VALIDATIONS IN A SPECIAL DTO CLASS
    Product productToUpdate = this.findById(product.getId());
    if(productToUpdate != null){
        return repository.save(product);
    }
    return null;
}

public void delete(Long id){
    Product productToDelete = this.findById(id);
    if(productToDelete != null){
        repository.deleteById(id);
    }
}
*/
