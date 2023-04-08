package dev.pmleczek.productservice.service;

import dev.pmleczek.productservice.entity.Product;
import dev.pmleczek.productservice.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Flux<Product> getProducts(int page, int pageSize) {
        return productRepository.findAll().skip((long) pageSize * page).take(page, true);
    }

    public Flux<Product> getProductsByQuery(String query, int page, int pageSize) {
        Product probe = new Product();
        probe.setName(query);
        probe.setDescription(query);
        Example<Product> example = Example.of(probe, ExampleMatcher.matchingAny()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return productRepository.findAll(example).skip((long) pageSize * page).take(pageSize, true);
    }
}
