package com.example.consumer_module_example_1.service;

import com.example.consumer_module_example_1.model.Product;
import org.springframework.stereotype.Service;
import com.example.consumer_module_example_1.proxy.ProductProxy;
import reactor.core.publisher.Flux;

@Service
public class ProductService {

    final ProductProxy productProxy;

    public ProductService(ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    public Flux<Product> getAllProduct() {
        return productProxy.consumeAllProducts();
    }
}
