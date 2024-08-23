package com.digital.spring_architecture_test.repositories;

import com.digital.spring_architecture_test.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
