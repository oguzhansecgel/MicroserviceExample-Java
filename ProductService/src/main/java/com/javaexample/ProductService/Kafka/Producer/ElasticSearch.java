package com.javaexample.ProductService.Kafka.Producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ElasticSearch {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    @Value("${spring.kafka.topic.product-topic.name}")
    private String EPTOPIC;

    @Value("${spring.kafka.topic.update-product-topic.name}")
    private String UPTOPIC;

    public ElasticSearch(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Object message) {
        kafkaTemplate.send(EPTOPIC,message);
        System.out.println("Mesaj Search Servisine Başarıyla Gönderildi. Gönderilen Mesaj :  " + message);
    }
    public void updateProduct(Object message) {
        kafkaTemplate.send(UPTOPIC,message);
        System.out.println("Mesaj Search Servisine Başarıyla Gönderildi. Gönderilen Mesaj :  " + message);
    }
}
