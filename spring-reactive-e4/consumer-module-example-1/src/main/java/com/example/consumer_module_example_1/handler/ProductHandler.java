package com.example.consumer_module_example_1.handler;

import com.example.consumer_module_example_1.service.ProductService;
import com.example.consumer_module_example_1.model.Product;
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

    public Mono<ServerResponse> handleAllProductFromConsumer(ServerRequest request) {
        //        request -> request body , headers, path variables, request params
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.getAllProduct(), Product.class);
    }


}
