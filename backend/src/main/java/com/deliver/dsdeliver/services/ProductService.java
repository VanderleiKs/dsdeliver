package com.deliver.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.deliver.dsdeliver.dto.ProductDto;
import com.deliver.dsdeliver.entities.Product;
import com.deliver.dsdeliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll(){
        List<Product> products = productRepository.findAllByOrderByNameAsc();
        return products.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
    }
     
}
