package com.javaexample.ProductService.Service.Abstracts;

import com.javaexample.ProductService.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    void deleteProduct(int id);
    Product createProduct(Product product);
    Product updateProduct(int id, Product product);
    List<Product> getAllProduct();
    Optional<Product> getProductById(int id);
}
