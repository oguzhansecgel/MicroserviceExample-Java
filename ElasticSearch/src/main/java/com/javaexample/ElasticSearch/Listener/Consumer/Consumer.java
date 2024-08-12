package com.javaexample.ElasticSearch.Listener.Consumer;

import com.javaexample.ElasticSearch.Document.Product;
import com.javaexample.ElasticSearch.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;
@Service
@Slf4j
public class Consumer {

    private final ProductRepository productRepository;

    public Consumer(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.elastic-topic.name}")
    public void listen(Product product)
    {
        productRepository.save(product);
        System.out.println("Product saved: " + product);
    }
}
