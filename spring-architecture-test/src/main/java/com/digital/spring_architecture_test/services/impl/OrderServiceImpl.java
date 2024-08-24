package com.digital.spring_architecture_test.services.impl;

import com.digital.spring_architecture_test.dto.ClientDto;
import com.digital.spring_architecture_test.dto.OrderDto;
import com.digital.spring_architecture_test.dto.ProductDto;
import com.digital.spring_architecture_test.dto.requests.OrderRequest;
import com.digital.spring_architecture_test.exceptions.ResourceNotFoundException;
import com.digital.spring_architecture_test.models.Order;
import com.digital.spring_architecture_test.models.Product;
import com.digital.spring_architecture_test.repositories.OrderRepository;
import com.digital.spring_architecture_test.services.ClientService;
import com.digital.spring_architecture_test.services.OrderService;
import com.digital.spring_architecture_test.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Override
    public List<OrderDto> findAll() {
        return this.repository.findAll().stream().map(OrderDto::new).toList();
    }

    @Override
    public OrderDto findById(Long id) {
        return this.repository
                .findById(id)
                .map(OrderDto::new)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    @Override
    public OrderDto create(OrderRequest orderRequest) {
        Order newOrder = new Order();
        //search client and products
        Double total = 0.0;
        ClientDto client = this.clientService.findById(orderRequest.getClientId());
        Set<Product> products = new HashSet<>();
        for (Long productId : orderRequest.getProductIds()) {
            ProductDto product = this.productService.findById(productId);
            total += product.getUnitPrice();
            products.add(product.toEntity());
        }

        newOrder.setPaymentType(orderRequest.getPaymentType());
        newOrder.setTotal(total);
        newOrder.setClient(client.toEntity());
        newOrder.setProducts(products);

        return new OrderDto(this.repository.save(newOrder));
    }

    @Override
    public OrderDto update(Long id, OrderRequest orderRequest) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        OrderDto orderDto = this.findById(id);
        this.repository.deleteById(orderDto.getId());
    }
}
