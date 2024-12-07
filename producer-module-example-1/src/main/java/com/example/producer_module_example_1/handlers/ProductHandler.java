package com.example.producer_module_example_1.handlers;

import com.example.producer_module_example_1.model.Product;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import com.example.producer_module_example_1.service.ProductService;

@Component
public class ProductHandler {
    private final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> handleAllProductFromProducer(ServerRequest request) {
//        request -> request body , headers, path variables, request params
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getAllProducts(), Product.class);
    }
}
