package com.javaexample.ElasticSearch.Service.Concretes;


import com.javaexample.ElasticSearch.Document.Product;
import com.javaexample.ElasticSearch.Repository.ProductRepository;
import com.javaexample.ElasticSearch.Service.Abstracts.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> productPriceBetween(Integer lower, Integer upper) {
        List<Product> products = productRepository.findByProductPriceBetween(lower,upper);
        return products;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        Iterable<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public List<Product> findByProductNameContaining(String productName) {
        List<Product> products = productRepository.findByProductNameContaining(productName.toLowerCase());
        return products;
    }

    @Override
    public Product updateProduct(Integer productId, Product product) {
        return productRepository.findById(productId)
                .map(existingProduct -> {
                    existingProduct.setProductName(product.getProductName());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setColor(product.getColor());
                    existingProduct.setProductPrice(product.getProductPrice());
                    existingProduct.setStock(product.getStock());

                    return productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }
}
