package com.sanvalero.myshop.repository;

import com.sanvalero.myshop.domain.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, Long> {

    Flux<Product> findAll();
}
