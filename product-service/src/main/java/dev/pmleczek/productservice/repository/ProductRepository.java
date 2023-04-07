package dev.pmleczek.productservice.repository;

import dev.pmleczek.productservice.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
