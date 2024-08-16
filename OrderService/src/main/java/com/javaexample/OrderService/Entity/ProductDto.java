package com.javaexample.OrderService.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int productId;
    private String productName;
    private String description;
    private String color;
    private int productPrice;
    private int stock;
}