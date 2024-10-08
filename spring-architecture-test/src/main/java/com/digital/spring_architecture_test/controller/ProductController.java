package com.digital.spring_architecture_test.controller;

import com.digital.spring_architecture_test.common.ApiResponse;
import com.digital.spring_architecture_test.dto.requests.ProductRequest;
import com.digital.spring_architecture_test.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> index() {
        return ApiResponse.collectionResponse(this.productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        return ApiResponse.singleResponse(this.productService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductRequest productRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Product created successfully",
                this.productService.create(productRequest),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody ProductRequest productRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Product updated successfully",
                this.productService.update(id, productRequest),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        this.productService.deleteById(id);
        return ApiResponse.messageResponse("Product deleted successfully", HttpStatus.OK);
    }
}
