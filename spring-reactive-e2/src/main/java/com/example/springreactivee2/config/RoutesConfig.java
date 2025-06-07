package com.example.springreactivee2.config;

import com.example.springreactivee2.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

//equivalent to centralized controller
@Configuration
public class RoutesConfig {

//    private final ProductService productService;
//
//    public RoutesConfig(ProductService productService) {
//        this.productService = productService;
//    }

    //expose endpoint reactively
    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler handler) {
        //a router function can have multiple route
        //can use multiple route chaining , but we focus on single route for now

        //I expose a route that will be trigger to the path products is called using Get Http Method
        //then a response with status okay will be sent back containing on the body whatever
        //get all return
        return RouterFunctions.route()
                .GET("/api/products", handler::getAllProducts)
                .build();

//        return RouterFunctions.route()
//                .GET(
//                        "/api/products",
//                        request -> ServerResponse.ok()
//                                .contentType(MediaType.TEXT_EVENT_STREAM)
//                                //what the flux will publish at the end it publishes a product
//                                .body(productService.getAllProducts(), Product.class)
//                )
//                .build();
    }
}
