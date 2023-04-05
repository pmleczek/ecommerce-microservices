package dev.pmleczek.productservice.repository;

import dev.pmleczek.productservice.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRespository extends ReactiveMongoRepository<Product, String> {
}
