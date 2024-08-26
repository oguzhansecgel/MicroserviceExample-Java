package com.javaexample.kafka_procuder.service;

import com.javaexample.kafka_procuder.dto.Product;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

    // Kafka template ile Key, Value değerleri belirlenir.
    private final KafkaTemplate<String,Object> kafkaTemplate;

    // application.prop yazdırılacak topic buraya yazılır.
    @Value("${spring.kafka.template.default-topic}")
    private String TOPIC;

    @Value("${spring.kafka.topic.elastic-topic.name}")
    private String ETOPIC;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // ilk başta topic daha sonra value değeri yollanır.
    public void sendMessage(Object message,int partion) {
        kafkaTemplate.send(TOPIC,partion,null,message);
        System.out.println("Mesaj Kafkaya Gönderildi. Gönderilen Mesaj :  " + message +" partion : "+partion);
    }

    public void sendElasticMessage(Object message) {
        kafkaTemplate.send(ETOPIC,message);
        System.out.println("Mesaj Kafkaya Gönderildi. Gönderilen Mesaj :  " + message);
    }


}
