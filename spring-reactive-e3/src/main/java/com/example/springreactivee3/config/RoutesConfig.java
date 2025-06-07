package com.example.springreactivee3.config;

import com.example.springreactivee3.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RoutesConfig {
    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler handler) {
        return RouterFunctions.route().GET("api/v2/call-products",handler::getAll).build();
    }
}
