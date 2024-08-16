package com.digital.injectionD.controllers;

import com.digital.injectionD.models.Product;
import com.digital.injectionD.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable(value = "id")Long id) {
        return productService.findById(id);
    }
}
