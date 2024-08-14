package com.javaexample.OrderService.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String productName;
    private String description;
    private String color;
    private int productPrice;
    private int stock;
}
