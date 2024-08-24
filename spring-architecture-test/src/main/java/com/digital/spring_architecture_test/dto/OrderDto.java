package com.digital.spring_architecture_test.dto;

import com.digital.spring_architecture_test.enums.PaymentType;
import com.digital.spring_architecture_test.models.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class OrderDto {

    private Long id;
    private PaymentType paymentType;
    private Double total;
    private ClientDto client;
    private Set<ProductDto> products;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    public OrderDto(Order order){
        this.id = order.getId();
        this.paymentType = order.getPaymentType();
        this.total = order.getTotal();
        this.client = new ClientDto(order.getClient());
        this.products = order.getProducts().stream().map(ProductDto::new).collect(Collectors.toSet());
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
    }

    public Order toEntity(){
        Order order = new Order();
        order.setId(this.id);
        order.setPaymentType(this.paymentType);
        order.setTotal(this.total);
        order.setClient(this.client.toEntity());
        order.setProducts(this.products.stream().map(ProductDto::toEntity).collect(Collectors.toSet()));
        order.setCreatedAt(this.createdAt);
        order.setUpdatedAt(this.updatedAt);
        return order;
    }
}
