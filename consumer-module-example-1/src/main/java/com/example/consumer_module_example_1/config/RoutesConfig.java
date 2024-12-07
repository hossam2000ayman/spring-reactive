package com.example.consumer_module_example_1.config;

import com.example.consumer_module_example_1.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutesConfig {
    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler) {
        return RouterFunctions.route()
                .GET("/api/consumer/products", productHandler::handleAllProductFromConsumer)
                .build();
    }
}
