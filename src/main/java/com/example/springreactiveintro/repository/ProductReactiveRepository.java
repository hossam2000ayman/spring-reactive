package com.example.springreactiveintro.repository;

import com.example.springreactiveintro.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReactiveRepository extends ReactiveCrudRepository<Product, Long> {

}
