package com.javaexample.ElasticSearch.Listener.Consumer;

import com.javaexample.ElasticSearch.Document.Product;
import com.javaexample.ElasticSearch.Repository.ProductRepository;
import com.javaexample.ElasticSearch.Service.Abstracts.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductConsumer {
    private final ProductRepository productRepository;
     private final ProductService productService;

    public ProductConsumer(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @KafkaListener(topics = "${spring.kafka.topic.product-topic.name}")
    public void listen(Product product)
    {
        productRepository.save(product);
        System.out.println("Product saved: " + product);
    }
    @KafkaListener(topics = "${spring.kafka.topic.update-product-topic.name}")
    public void updateListener(Product product)
    {
        productService.updateProduct(product.getProductId(),product);
        System.out.println("Product saved: " + product);
    }

}
