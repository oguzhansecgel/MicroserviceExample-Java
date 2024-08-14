package com.javaexample.ElasticSearch.Listener.Consumer;

import com.javaexample.ElasticSearch.Document.Product;
import com.javaexample.ElasticSearch.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductConsumer {
    private final ProductRepository productRepository;

    public ProductConsumer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.product-topic.name}")
    public void listen(Product product)
    {
        productRepository.save(product);
        System.out.println("Product saved: " + product);
    }
}
