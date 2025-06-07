package com.example.springreactivee3.proxy;

import com.example.springreactivee3.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class ProductProxy {
    final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    // Get From Other endpoint
    public Flux<Product> getAll() {
        return webClient.get()
                .uri("api/products")
                .exchangeToFlux(response -> response.bodyToFlux(Product.class));
    }
}
