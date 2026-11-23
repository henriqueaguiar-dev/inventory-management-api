package com.portfolio.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.inventory.entity.ProductEntity;
import com.portfolio.inventory.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductEntity product) {

        if (productRepository.existsBySku(product.getSku())) {
            throw new IllegalArgumentException(
                    "A product with this SKU already exists.");
        }

        return productRepository.save(product);
    }

    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "No product found with the given ID."));
    }

}
