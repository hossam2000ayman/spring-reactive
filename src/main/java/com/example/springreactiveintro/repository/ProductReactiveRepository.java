package com.example.springreactiveintro.repository;

import com.example.springreactiveintro.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The product repository is an interface that is abstract structure in java and the implementation
 * of the bean itself is configured automatically in the context by using spring data (jpa, reactive, mongo, etc.)
 *
 * In details spring can instantiate the stereotyped for the non-abstract classes like interfaces
 * so adding @Repository isn't make any sense because we cannot instantiate new object from (abstract type)
 *
 * Stereotype annotation is used to mark non-abstract classes only to be added into spring context
 * */
public interface ProductReactiveRepository extends ReactiveCrudRepository<Product, Long> {

}
