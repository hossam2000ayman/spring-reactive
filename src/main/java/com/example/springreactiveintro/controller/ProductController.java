package com.example.springreactiveintro.controller;

import com.example.springreactiveintro.model.Product;
import com.example.springreactiveintro.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/products")
public class ProductController {
    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //there is still one more thing need to be done otherwise it will treat it as a normal endpoint and you will get every thing at the end
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    //this is mean by I am not producing a simple json, but I am producing a event
    public Flux<Product> getProducts() {
        return productService.getAllProducts();
    }
}
