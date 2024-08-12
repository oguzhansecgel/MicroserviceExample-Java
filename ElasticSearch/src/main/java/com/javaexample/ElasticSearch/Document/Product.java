package com.javaexample.ElasticSearch.Document;

import jakarta.annotation.Generated;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private int id;
    private String productName;
    private String description;
    private String color;
    private int productPrice;
    private boolean isInStock;



}
