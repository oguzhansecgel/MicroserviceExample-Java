package com.javaexample.ElasticSearch.Repository;

import com.javaexample.ElasticSearch.Document.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product,Integer> {

    List<Product> findByProductPriceBetween(Integer lower, Integer upper);

    @Query("{ \"bool\": { \"must\": [ { \"wildcard\": { \"productName\": \"*?0*\" } } ] } }")
    List<Product> findByProductNameContaining(@Param("productName") String productName);



}
