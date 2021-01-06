package com.deliver.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.deliver.dsdeliver.dto.OrderDto;
import com.deliver.dsdeliver.dto.ProductDto;
import com.deliver.dsdeliver.entities.Order;
import com.deliver.dsdeliver.entities.OrderStatus;
import com.deliver.dsdeliver.entities.Product;
import com.deliver.dsdeliver.repositories.OrderRepository;
import com.deliver.dsdeliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAllOrdersPending();
        return orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDto insert(OrderDto dto) {
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for (ProductDto p : dto.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = orderRepository.save(order);
        return new OrderDto(order);
    }

    @Transactional
    public OrderDto setDelivered(Long id){
        Order order = orderRepository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = orderRepository.save(order);
        return new OrderDto(order);
    }
}
