package com.example.springreactivee2.handlers;

import com.example.springreactivee2.model.Product;
import com.example.springreactivee2.service.ProductService;
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

    //in read world app the request added as parameter to get it's
    // - RequestBody  .body(...)
    // - RequestParam .attribute(...)
    // - PathVariable
    // - RequestHeader
    public Mono<ServerResponse> getAllProducts(ServerRequest request) {

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getAll(), Product.class);
    }

}
