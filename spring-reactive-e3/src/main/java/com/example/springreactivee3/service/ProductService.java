package com.example.springreactivee3.service;

import com.example.springreactivee3.model.Product;
import com.example.springreactivee3.proxy.ProductProxy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductService {
    final ProductProxy productProxy;

    public ProductService(ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    public Flux<Product> getAll() {
        return productProxy.getAll();
    }
}
