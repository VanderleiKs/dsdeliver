package com.deliver.dsdeliver.controllers;

import java.util.List;

import com.deliver.dsdeliver.dto.OrderDto;
import com.deliver.dsdeliver.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
    
}
