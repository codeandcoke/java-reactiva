package com.sanvalero.myshop.service;

import com.sanvalero.myshop.domain.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<Product> findAllProducts();
    Mono<Product> findProduct(long id);
}
