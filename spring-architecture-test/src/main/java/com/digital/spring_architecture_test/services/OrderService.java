package com.digital.spring_architecture_test.services;

import com.digital.spring_architecture_test.dto.OrderDto;
import com.digital.spring_architecture_test.dto.requests.OrderRequest;
import com.digital.spring_architecture_test.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderDto> findAll();
    OrderDto findById(Long id);
    OrderDto create(OrderRequest orderRequest);
    OrderDto update(Long id, OrderRequest orderRequest);
    void deleteById(Long id);
}
