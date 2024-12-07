package com.example.producer_module_example_1.config;

import com.example.producer_module_example_1.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
@Configuration
public class RouterConfig {
//    private final ProductService productService;
//
//    public RouterConfig(ProductService productService) {
//        this.productService = productService;
//    }

//    @Bean
//    public RouterFunction<ServerResponse> router(ProductService productService) {
//    //not clean way to use example.service directly
//        return RouterFunctions.route()
//                .GET("/api/v1/products",
//                        request -> ServerResponse.ok()
//                                .contentType(MediaType.TEXT_EVENT_STREAM)
//                                .body(productService.getAllProducts(), Product.class))
//                .build();
//    }


    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler) {
        return RouterFunctions.route()
                .GET("api/producer/products", productHandler::handleAllProductFromProducer)
                .build();
    }

}
