package com.javaexample.OrderService.Kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductProducer {


    private final KafkaTemplate<String,Object> kafkaTemplate;

    @Value("${spring.kafka.topic.product-stoc-topic.name}")
    private String PSTOPIC;

    public ProductProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Object message) {
        kafkaTemplate.send(PSTOPIC,message);
        System.out.println("Ürün sipariş verildi stok azaltma işlemi :  " + message);
    }
}
