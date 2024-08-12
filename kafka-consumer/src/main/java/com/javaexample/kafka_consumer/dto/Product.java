package com.javaexample.kafka_consumer.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private String productName;
    private String description;
    private String color;
    private int productPrice;
    private boolean isInStock;
}
