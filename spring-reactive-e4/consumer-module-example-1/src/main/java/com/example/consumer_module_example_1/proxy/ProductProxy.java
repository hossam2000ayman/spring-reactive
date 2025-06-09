package com.example.consumer_module_example_1.proxy;

import com.example.consumer_module_example_1.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Flux;

@Component
public class ProductProxy {
    //to reactively consumes endpoints, routes from reactive application we need to a reactive client
    final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> consumeAllProducts() {
        Product defaultProduct = new Product();
        defaultProduct.setName("default product");

        return webClient.get()
                .uri("api/producer/products")
                .exchangeToFlux(response -> response.bodyToFlux(Product.class));
                // if there is error occur resume with default product and ignore the old result that try to be fetched

//                .doOnNext(n -> {
//                    if (null == n.getName())
//                        throw new NullPointerException();
//                })
//                .onErrorResume(e-> Flux.just(defaultProduct));//not recommended in real world scenario
//                .onErrorResume(WebClientRequestException.class, e -> Flux.just(defaultProduct));// recommended
//                .onErrorResume(e -> e instanceof NullPointerException, e -> Flux.just(defaultProduct));// recommended for more generic exceptions but more recommended to make it more specific based on the type
                //either use onErrorResume or onErrorReturn
//                .onErrorReturn(defaultProduct)
//                .onErrorReturn(WebClientRequestException.class, defaultProduct)
//                .onErrorReturn(e -> e instanceof NullPointerException, defaultProduct)

                //on of approaches in spring reactive is to make exception handler using custom exceptions
                //make auto response for each type of exceptions
//                .onErrorMap(e -> new Exception())
//                .onErrorContinue((e, o) -> System.out.println(e.getMessage()));
//                .onErrorContinue(RuntimeException.class, (e, o) -> System.out.println(e.getMessage()))
//                .onErrorContinue(e -> e.getMessage().contains("not found"), (e, o) -> System.out.println("Error occurred: " + e.getMessage() + ", for object: " + o))
//                .retry(3);


    }
}
