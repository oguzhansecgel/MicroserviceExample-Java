package com.javaexample.ElasticSearch.Service.Abstracts;

import com.javaexample.ElasticSearch.Document.Product;

import java.util.List;

public interface ProductService {

    List<Product> productPriceBetween(Integer lower, Integer upper);
    Iterable<Product> getAllProducts();
    List<Product> findByProductNameContaining(String productName);
}
