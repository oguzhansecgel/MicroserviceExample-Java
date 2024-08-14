package com.javaexample.ProductService.Repository;

import com.javaexample.ProductService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
