package com.sanvalero.myshop.service;

import com.sanvalero.myshop.domain.Product;
import com.sanvalero.myshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Flux<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findProduct(long id) {
        return productRepository.findById(id);
    }
}
