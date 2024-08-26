package com.javaexample.kafka_consumer.listener;

import com.javaexample.kafka_consumer.dto.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerListener {


    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}",topicPartitions = {@TopicPartition(topic = "${spring.kafka.template.default-topic}",partitions = {"1"})})
    public void consumer(ConsumerRecord<String, Product> payload) {
        System.out.println("Consumer tarafından mesaj alındı  : " + payload.value());
    }

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}", topicPartitions = {@TopicPartition(topic = "${spring.kafka.template.default-topic}",partitions = {"2"})})
    public void consumer2(ConsumerRecord<String, Product> payload) {
        System.out.println("Consumer2 tarafından mesaj alındı  : " + payload.value() + " Partition: " + payload.partition());
    }

}
