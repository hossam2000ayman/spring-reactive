package com.example.springreactivee3.handler;

import com.example.springreactivee3.model.Product;
import com.example.springreactivee3.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
    final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    //we choose to receive from other server port 8080 for example in reactive way
    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(productService.getAll(), Product.class);
    }
}
