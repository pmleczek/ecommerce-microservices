package dev.pmleczek.productservice.dto;

import dev.pmleczek.productservice.entity.Product;

public record ShortProductResponse(String id, String name, Double price) {
    public static ShortProductResponse toShortProductResponse(Product product) {
        return new ShortProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
