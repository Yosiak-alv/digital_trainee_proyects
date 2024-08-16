package com.digital.springJpa.repositories;

import com.digital.springJpa.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p")
    List<Product> findAll();

    @Query("select p from Product p where p.isActive = ?1")
    List<Product> findActiveProducts(Boolean isActive);

    @Query("select p from Product p where p.name like %?1%")
    List<Product> findByNameLike(String name);

    @Query("select p from Product p where p.name = ?1 and p.isActive = ?2")
    List<Product> findByNameAndIsActive(String name, Boolean isActive);

    @Query("select p from Product p where p.name = ?1")
    Optional<Product> findByName(String name);
}
