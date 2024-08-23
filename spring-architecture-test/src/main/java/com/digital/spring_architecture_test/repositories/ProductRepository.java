package com.digital.spring_architecture_test.repositories;

import com.digital.spring_architecture_test.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
