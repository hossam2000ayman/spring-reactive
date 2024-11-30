package com.example.springreactiveintro.service;

import com.example.springreactiveintro.model.Product;
import com.example.springreactiveintro.repository.ProductReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class ProductService {
    final ProductReactiveRepository productReactiveRepository;

    public ProductService(ProductReactiveRepository productReactiveRepository) {
        this.productReactiveRepository = productReactiveRepository;
    }

    //    List, Set , Collections ==> Flux (streams of product stream of events that are returning)
//    Flux is a pipeline of events and the products which is basically the event that are flowing through the pipeline
    public Flux<Product> getAllProducts() {//whole methods takes 10 seconds to finish
        return productReactiveRepository.findAll() //products
                .delayElements(Duration.ofSeconds(5)); //for any element add a sleep duration
    }
}
