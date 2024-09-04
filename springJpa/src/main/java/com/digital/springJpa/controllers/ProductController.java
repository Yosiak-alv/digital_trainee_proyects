package com.digital.springJpa.controllers;

import com.digital.springJpa.models.Product;
import com.digital.springJpa.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/api/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    private List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Product> findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Product product, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        return ResponseEntity.status(201).body(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Product product, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        Optional<Product> productOptional = productService.update(id, product);
        if(productOptional.isPresent()){
            return ResponseEntity.ok().body(productOptional);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Product> product = productService.delete(id);
        if(product.isPresent()){
            return ResponseEntity.ok().body(product);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> validation(BindingResult result){
        Map<String, Object> errors = Map.of("errors", result.getAllErrors());
        result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
