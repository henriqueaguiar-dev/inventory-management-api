package com.portfolio.inventory.repository;
import com.portfolio.inventory.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
    
    boolean existsBySku(String sku);
}

