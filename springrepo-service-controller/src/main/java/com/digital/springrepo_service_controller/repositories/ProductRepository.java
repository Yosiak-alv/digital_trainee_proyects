package com.digital.springrepo_service_controller.repositories;

import com.digital.springrepo_service_controller.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    boolean existsBySku(String sku);
}
