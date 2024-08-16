package com.digital.springJpa.services;

import com.digital.springJpa.models.Product;
import com.digital.springJpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

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




}
