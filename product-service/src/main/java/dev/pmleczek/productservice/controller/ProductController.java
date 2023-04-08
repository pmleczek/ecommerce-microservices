package dev.pmleczek.productservice.controller;

import dev.pmleczek.productservice.dto.FullProductResponse;
import dev.pmleczek.productservice.dto.ShortProductResponse;
import dev.pmleczek.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Mono<FullProductResponse> getProductById(@PathVariable String productId) {
        return productService.getProductById(productId).map(FullProductResponse::toFullProductResponse);
    }

    @GetMapping
    public Flux<ShortProductResponse> getProducts(@RequestParam int page, @RequestParam(name = "pagesize") int pageSize) {
        return productService.getProducts(page - 1, pageSize).map(ShortProductResponse::toShortProductResponse);
    }

    @GetMapping("/search")
    public Flux<ShortProductResponse> getProductsByQuery(@RequestParam int page,
                                                         @RequestParam(name = "pagesize") int pageSize,
                                                         @RequestParam String query) {
        return productService.getProductsByQuery(query, page, pageSize).map(ShortProductResponse::toShortProductResponse);
    }
}
