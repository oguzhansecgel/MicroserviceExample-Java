package com.javaexample.ProductService.Service.Abstracts;

import com.javaexample.ProductService.Entity.Product;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface ProductService {

    void deleteProduct(int id);
    Product createProduct(Product product);
    Product updateProduct(int id, Product product);
    Page<Product> getAllProduct(Pageable pageable);
    Optional<Product> getProductById(int id);
    Integer getProductStockCount(int productId);
    void decrementStock(int productId);
}
