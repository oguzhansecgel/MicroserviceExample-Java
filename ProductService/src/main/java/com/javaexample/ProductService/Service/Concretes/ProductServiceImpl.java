package com.javaexample.ProductService.Service.Concretes;

import com.javaexample.ProductService.Entity.Product;
import com.javaexample.ProductService.Kafka.Producer.ElasticSearch;
import com.javaexample.ProductService.Repository.ProductRepository;
import com.javaexample.ProductService.Service.Abstracts.ProductService;
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
        productRepository.deleteById(id);
    }

    @Override
    public Product createProduct(Product product) {
        elasticSearchProducer.sendMessage(product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productRepository.saveAndFlush(product);

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }


}
