package com.deliver.dsdeliver.controllers;

import java.net.URI;
import java.util.List;

import com.deliver.dsdeliver.dto.OrderDto;
import com.deliver.dsdeliver.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
    
    @PostMapping
    public ResponseEntity<OrderDto> insert(@RequestBody OrderDto dto){
        OrderDto dtoSave = orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoSave);
    }
}
