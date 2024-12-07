package com.example.consumer_module_example_1.proxy;

import com.example.consumer_module_example_1.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class ProductProxy {
    //to reactively consumes endpoints, routes from reactive application we need to a reactive client
    final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> consumeAllProducts() {
        return webClient.get().uri("api/producer/products")
                .exchangeToFlux(response -> response.bodyToFlux(Product.class));

    }
}
