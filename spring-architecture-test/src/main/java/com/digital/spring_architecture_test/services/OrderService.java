package com.digital.spring_architecture_test.services;

import com.digital.spring_architecture_test.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    Order create(Order order);
    Optional<Order> update(Long id, Order order);
    void delete(Long id);
}
