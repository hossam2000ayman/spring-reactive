package com.example.producer_module_example_1.service;

import com.example.producer_module_example_1.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class ProductService {
    // List, Set , Collections ==> Flux (streams of product stream of events that are returning)
    // Flux is a pipeline of events and the products which is basically the event that are flowing through the pipeline
    public Flux<Product> getAllProducts() {
        Product p1 = new Product();
        p1.setName("Sandwich");
        Product p2 = new Product();
        p2.setName("Chocolate");
        Product p3 = new Product();
        p3.setName("Soda");
        Product productWithoutName = new Product();
        Product p4 = new Product();
        p3.setName("Natella");
        Flux<Product> products = Flux.fromStream(List.of(p1, p2, productWithoutName, p3, p4).stream()).delayElements(Duration.ofSeconds(5L)); //simulate something happens with each product

        return products;
    }
}
