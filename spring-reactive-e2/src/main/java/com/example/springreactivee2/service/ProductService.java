package com.example.springreactivee2.service;

import com.example.springreactivee2.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {

    //Flux<T> is a Publisher<T>
    //Flux<T> is just like a List<T> but it's not static, so
    // you can imagine events flowing through the flux
    public Flux<Product> getAll() {
        Product p1 = new Product();
        p1.setName("Product 1");
        Product p2 = new Product();
        p2.setName("Product 2");
        Product p3 = new Product();
        p3.setName("Product 3");
        Product p4 = new Product();
        p4.setName("Product 4");
        Product p5 = new Product();
        p5.setName("Product 5");
        Product p6 = new Product();
        p6.setName("Product 6");

        Flux<Product> products = Flux.fromStream(
                List.of(p1, p2, p3, p4, p5, p6).stream()
//                Stream.of(p1, p2, p3, p4, p5, p6)
        ).delayElements(Duration.ofSeconds(2L));//simulate something happened with each product

        return products;
    }
}
