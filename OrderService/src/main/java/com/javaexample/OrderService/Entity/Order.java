package com.javaexample.OrderService.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "orders")
public class Order {

    @Id
    private String orderId;
    private String productName;
    private String description;
    private String color;
    private int productPrice;
    private int stock;
    public void setOrderId() {
        this.orderId = UUID.randomUUID().toString();
    }
}
