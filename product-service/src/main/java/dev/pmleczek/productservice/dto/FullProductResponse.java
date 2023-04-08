package dev.pmleczek.productservice.dto;

import dev.pmleczek.productservice.entity.Product;

public record FullProductResponse(String id, String name, String description, Double price) {
    public static FullProductResponse toFullProductResponse(Product product) {
        return new FullProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
