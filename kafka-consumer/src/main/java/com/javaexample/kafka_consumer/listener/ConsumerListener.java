package com.javaexample.kafka_consumer.listener;

import com.javaexample.kafka_consumer.dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListener {


    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void consumer(ConsumerRecord<String, Product> payload)
    {
        System.out.println(payload.value());

    }
}
