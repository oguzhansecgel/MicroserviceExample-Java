package com.javaexample.OrderService.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
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
    private CustomerDto customer;
    private ProductDto products;
    public void setOrderId() {
        this.orderId = UUID.randomUUID().toString();
    }
}
