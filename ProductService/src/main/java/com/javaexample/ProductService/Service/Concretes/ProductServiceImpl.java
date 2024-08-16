package com.javaexample.ProductService.Service.Concretes;

import com.javaexample.ProductService.Entity.Product;
import com.javaexample.ProductService.Kafka.Producer.ElasticSearch;
import com.javaexample.ProductService.Repository.ProductRepository;
import com.javaexample.ProductService.Service.Abstracts.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ElasticSearch elasticSearchProducer;

    public ProductServiceImpl(ProductRepository productRepository, ElasticSearch elasticSearchProducer) {
        this.productRepository = productRepository;
        this.elasticSearchProducer = elasticSearchProducer;
    }


    @Override
    public void deleteProduct(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product); // Önce kaydedin
        elasticSearchProducer.sendMessage(savedProduct); // Sonra mesajı gönderin
        return savedProduct;
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productRepository.saveAndFlush(product);

    }

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }



    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Integer getProductStockCount(int productId) {
        return productRepository.stockCount(productId);
    }

    @Override
    public void decrementStock(int productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() <= 0) {
            throw new RuntimeException("Stock is already zero");
        }

        product.setStock(product.getStock() - 1);
        productRepository.save(product);
    }

    @Override
    public boolean existsById(int id) {
        boolean existProduct = productRepository.existsById(id);
        return existProduct;

    }


}
