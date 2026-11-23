package com.portfolio.inventory.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.inventory.entity.ProductEntity;
import com.portfolio.inventory.service.ProductService;

@RestController
@RequestMapping("/products")
public class productController {

    private final ProductService productService;

    public productController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {

        ProductEntity savedProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);

    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAllProducts() {
        List<ProductEntity> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findProductById(@PathVariable Long id) {
        ProductEntity product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }
}
