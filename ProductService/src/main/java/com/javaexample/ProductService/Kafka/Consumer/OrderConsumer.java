package com.javaexample.ProductService.Kafka.Consumer;

import com.javaexample.ProductService.Entity.Product;
import com.javaexample.ProductService.Repository.ProductRepository;
import com.javaexample.ProductService.Service.Abstracts.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {
    private final ProductRepository productRepository;
    private final ProductService productService;

    public OrderConsumer(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }


    @KafkaListener(topics = "${spring.kafka.topic.product-stoc-topic.name}")
    public void listen(Product product)
    {
        productService.decrementStock(product.getProductId());
        System.out.println("Ürünün Stoğu azaltıldı." + product);
    }
}
