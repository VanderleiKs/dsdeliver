package com.deliver.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.deliver.dsdeliver.dto.OrderDto;
import com.deliver.dsdeliver.entities.Order;
import com.deliver.dsdeliver.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderDto> findAll(){
        List<Order> orders = orderRepository.findAllOrdersPending();
        return orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
    }
}
